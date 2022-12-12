CREATE OR REPLACE TRIGGER trigger_grup_data_creacio
  BEFORE INSERT OR UPDATE ON ART_GRUP
  FOR EACH ROW
BEGIN
  IF (sysdate < :new.ARTG_DATA_CREACIO)
  THEN
    RAISE_APPLICATION_ERROR(-20001, 'La data de creacio no pot ser futura!');
  END IF;
END;



CREATE OR REPLACE TRIGGER trigger_ind_data_naixement
  BEFORE INSERT OR UPDATE ON ART_IND
  FOR EACH ROW
BEGIN
  IF (sysdate < :new.ARTI_DATA_NAIXAMENT)
  THEN
    RAISE_APPLICATION_ERROR(-20002, 'La data de naixement no pot ser futura!');
  END IF;
END;


/*
CREATE OR REPLACE TRIGGER trigger_canco_any_creacio
  BEFORE INSERT OR UPDATE ON CANÇO
  FOR EACH ROW
BEGIN
  IF (to_number(to_char(sysdate, 'YY-MM-dd')) < :new.CAN_ANY_CREACIO)
  THEN
    RAISE_APPLICATION_ERROR(-20003, 'L''any de creacio no pot ser futur!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_album_any_creacio
  BEFORE INSERT OR UPDATE ON ALBUM
  FOR EACH ROW
BEGIN
  IF (to_number(to_char(sysdate, 'YY-MM-dd')) < :new.ALB_ANY_CREACIO)
  THEN
    RAISE_APPLICATION_ERROR(-20004, 'L''any de creacio no pot ser futur!');
  END IF;
END;

*/


CREATE OR REPLACE TRIGGER trigger_hgrup_data_inici
  BEFORE INSERT OR UPDATE ON H_GRUP
  FOR EACH ROW
BEGIN
  IF (sysdate < :new.HG_DATA_INICI)
  THEN
    RAISE_APPLICATION_ERROR(-20005, 'La data d''inici no pot ser futura!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_canco_durada
  BEFORE INSERT OR UPDATE ON CANÇO
  FOR EACH ROW
BEGIN
  IF (:new.CAN_DURADA <= 0)
  THEN
    RAISE_APPLICATION_ERROR(-20006, 'La durada no pot ser 0 o negativa!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_llista_durada
  BEFORE INSERT OR UPDATE ON LLISTA
  FOR EACH ROW
BEGIN
  IF (:new.LLI_DURADA < 0)
  THEN
    RAISE_APPLICATION_ERROR(-20007, 'La durada no pot ser 0 o negativa!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_album_durada
  BEFORE INSERT OR UPDATE ON ALBUM
  FOR EACH ROW
BEGIN
  IF (:new.ALB_DURADA < 0)
  THEN
    RAISE_APPLICATION_ERROR(-20008, 'La durada no pot ser 0 o negativa!');
  END IF;
END;


CREATE OR REPLACE TRIGGER trigger_client_virtual_delete
  BEFORE DELETE ON CLIENT
  FOR EACH ROW
BEGIN
  IF (:old.CLI_ID = 0)
  THEN
    RAISE_APPLICATION_ERROR(-20009, 'No es pot esborrar un client virtual!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_llista_tipus
  BEFORE INSERT OR UPDATE ON LLISTA
  FOR EACH ROW
DECLARE
  v_tipus CATALEG.CAT_TIPUS%type;
BEGIN
  SELECT CAT_TIPUS INTO v_tipus FROM CATALEG WHERE CAT_ID = :new.LLI_ID;
  IF (v_tipus != 'L')
  THEN
    RAISE_APPLICATION_ERROR(-20010, 'No es pot inserir una llista dintre de un altre llista!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_delete_client
  BEFORE DELETE ON CLIENT
  FOR EACH ROW
DECLARE
  rep_count number;
BEGIN
  SELECT COUNT(*) INTO rep_count FROM REPRODUCIO repro WHERE repro.REP_ID_CLIENT = :old.CLI_ID;
  IF (rep_count > 0) THEN
    UPDATE REPRODUCIO set REP_ID_CLIENT = 0 WHERE REP_ID_CLIENT = :old.CLI_ID;
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_delete_producte
  BEFORE DELETE ON CATALEG
  FOR EACH ROW
DECLARE
  rep_count number;
BEGIN
  SELECT COUNT(*) INTO rep_count FROM CATALEG where :old.CAT_ID IN (SELECT REP_ID_CATALAG FROM REPRODUCIO);
  if (rep_count > 0) then
    RAISE_APPLICATION_ERROR(-20011, 'No es pot esborrar un producte que ha estat reproduit!');
  END IF;
END;

/*
*No funciona no se perque
*/
CREATE OR REPLACE TRIGGER trigger_delete_artista
  BEFORE DELETE ON ARTISTA
  FOR EACH ROW
DECLARE
  count1 number;
  count2 number;
begin
  SELECT COUNT (*) INTO count1 FROM CANÇO can where can.CAN_INTERPRET = :old.ARTI_ID;
  SELECT COUNT (*) INTO count2 FROM AUTORIA aut where aut.AUT_ARTIND = :old.ARTI_ID;
  if (count1 > 0 or count2 > 0) THEN
    RAISE_APPLICATION_ERROR(-20012, 'No es pot esborrar un artista que ha estat utilitzat (interpret o canco)!');
  END IF;
end;

CREATE OR REPLACE TRIGGER trigger_durada_album_contingut
  AFTER INSERT OR DELETE OR UPDATE OF ALCO_ID_CANÇO
  ON ALBUM_CONTINGUT
  FOR EACH ROW
DECLARE
  v_durada number;
  v_tipus char(1);
BEGIN
  if inserting or updating THEN
    SELECT CAT_TIPUS INTO v_tipus FROM CATALEG WHERE CAT_ID = :new.ALCO_ID_CANÇO;
    IF v_tipus = 'C' THEN
      SELECT canco_durada INTO v_durada FROM CANCO where canco_id = :new.ALCO_ID_CANÇO;
      UPDATE ALBUM SET ALB_DURADA = ALB_DURADA + v_durada WHERE ALB_ID = :new.ALCO_ID_ALBUM;
    END IF;
  END IF;

  if deleting or updating THEN
    select CAT_TIPUS into v_tipus from CATALEG where CAT_ID = :old.ALCO_ID_CANÇO;
    if v_tipus = 'C' THEN
      select canco_durada into v_durada from canco where canco_id = :old.ALCO_ID_CANÇO;
      update ALBUM set ALB_DURADA = ALB_DURADA - v_durada where ALB_ID = :old.ALCO_ID_ALBUM;
    end if;
  end if;
END;


CREATE OR REPLACE TRIGGER trigger_durada_album_after_update_durada_canco
  AFTER UPDATE OF CAN_DURADA
  ON CANÇO
  FOR EACH ROW
DECLARE
BEGIN
  UPDATE ALBUM
  SET ALB_DURADA = ALB_DURADA - :old.CAN_DURADA + :new.CAN_DURADA
  WHERE ALB_ID IN (SELECT ALCO_ID_ALBUM 
                     FROM ALBUM_CONTINGUT 
                     WHERE ALCO_ID_CANÇO = :old.CAN_ID);
END;



create or replace trigger trigger_durada_llista_contingut
after insert or delete or update of LLCON_ID_CATALAG
on LLISTA_CONTINGUT
for each ROW
declare 
v_durada number(6);
v_tipus char(1);
begin
    if inserting or updating THEN
        select CAT_TIPUS into v_tipus from CATALEG where CAT_ID = :new.LLCON_ID_CATALAG;
        if v_tipus = 'C' THEN
            select CAN_DURADA into v_durada from CANÇO where CAN_ID = :new.LLCON_ID_CATALAG;
            update LLISTA set LLI_DURADA = LLI_DURADA + v_durada where LLI_ID = :new.LLCON_ID_LLISTA;
        end if;
        if v_tipus = 'A' THEN
            select alb_durada into v_durada from ALBUM where ALB_ID = :new.LLCON_ID_CATALAG;
            update LLISTA set LLI_DURADA = LLI_DURADA + v_durada where LLI_ID = :new.LLCON_ID_LLISTA;
        end if;    
    end if;    

    if deleting or updating THEN
        select CAT_TIPUS into v_tipus from CATALEG where CAT_ID = :old.LLCON_ID_CATALAG;
        if v_tipus = 'C' THEN
            select CAN_DURADA into v_durada from CANÇO where CAN_ID = :old.LLCON_ID_CATALAG;
            update LLISTA set LLI_DURADA = LLI_DURADA - v_durada where LLI_ID = :old.LLCON_ID_LLISTA;
        end if;
        if v_tipus = 'A' THEN
            select alb_durada into v_durada from ALBUM where ALB_ID = :old.LLCON_ID_CATALAG;
            update LLISTA set LLI_DURADA = LLI_DURADA - v_durada where LLI_ID = :old.LLCON_ID_LLISTA;
        end if;    
    end if;    
end;



create or replace trigger trigger_durada_llista_aft_update_dur_canco
after update of CAN_DURADA on CANÇO
for each ROW
BEGIN

    update LLISTA
    set LLI_DURADA = LLI_DURADA - :old.CAN_DURADA + :new.CAN_DURADA
    where LLI_ID in (select LLCON_ID_LLISTA
                   from LLISTA_CONTINGUT
                   where LLCON_ID_CATALAG = :old.CAN_ID);
END;