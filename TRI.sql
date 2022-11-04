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

CREATE OR REPLACE TRIGGER trigger_canco_any_creacio
  BEFORE INSERT OR UPDATE ON CANÇO
  FOR EACH ROW
BEGIN
  IF (to_number(to_char(sysdate, 'YYYY')) < :new.CAN_ANY_CREACIO)
  THEN
    RAISE_APPLICATION_ERROR(-20003, 'L''any de creacio no pot ser futur!');
  END IF;
END;

CREATE OR REPLACE TRIGGER trigger_album_any_creacio
  BEFORE INSERT OR UPDATE ON ALBUM
  FOR EACH ROW
BEGIN
  IF (to_number(to_char(sysdate, 'YYYY')) < :new.ALB_ANY_CREACIO)
  THEN
    RAISE_APPLICATION_ERROR(-20004, 'L''any de creacio no pot ser futur!');
  END IF;
END;

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
    SELECT CAT_TIPUS INTO v_tipus FROM CATALEG WHERE CAT_ID = :new.ALCO_ID_ALBUM;
    IF (v_tipus = 'C') THEN
      SELECT CAN_DURADA INTO v_durada FROM CANCO where CAN_ID = :new.ALCO_ID_CANÇO;
      UPDATE ALBUM SET ALB_DURADA = ALB_DURADA + v_durada WHERE ALB_ID = :new.ALCO_ID_ALBUM;
    END IF;
  END IF;

  if deleting or updating then
    select CAT_TIPUS into v_tipus from CATALEG where CAT_ID = :old.ALCO_ID_ALBUM;
    if (v_tipus = 'C') then
      select CAN_DURADA into v_durada from canco where CAN_ID = :old.ALCO_ID_CANÇO;
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


/*
CREATE OR REPLACE TRIGGER trigger_durada_llista_contingut
  AFTER INSERT OR DELETE OR UPDATE OF llista_con_id_canco
  ON LLISTA_CONTINGUT
  FOR EACH ROW
DECLARE
  v_durada number;
  v_tipus char(1);
BEGIN
  if INSERTING OR UPDATING THEN
    select producte_tipus into v_tipus from PRODUCTE where producte_id = :new.llista_con_id_canco;
    IF (v_tipus = 'C') THEN
      select canco_durada into v_durada from CANCO where CAN_ID = :new.llista_con_id_canco;
      update LLISTA set llista_durada = llista_durada + v_durada where llista_id = :new.llista_con_id_llista;
    END IF;
    IF (v_tipus = 'A') THEN
      select album_durada into v_durada from ALBUM where album_id = :new.llista_con_id_canco;
      update LLISTA set llista_durada = llista_durada + v_durada where llista_id = :new.llista_con_id_llista;
    END IF;
  END IF;

  if DELETING OR UPDATING then
    select producte_tipus into v_tipus from PRODUCTE where producte_id = :old.llista_con_id_canco;
    if (v_tipus = 'C') then
      select canco_durada into v_durada from CANCO where canco_id = :old.llista_con_id_canco;
      update LLISTA set llista_durada = llista_durada - v_durada where llista_id = :old.llista_con_id_llista;
    end if;
    if (v_tipus = 'A') then
      select album_durada into v_durada from ALBUM where album_id = :old.llista_con_id_canco;
      update LLISTA set llista_durada = llista_durada - v_durada where llista_id = :old.llista_con_id_llista;
    end if;
  end if;
END;

CREATE OR REPLACE TRIGGER trigger_durada_llista_after_update_durada_canco
  AFTER UPDATE OF canco_durada
  ON CANCO
  FOR EACH ROW
DECLARE
BEGIN
  UPDATE LLISTA
  SET llista_durada = llista_durada - :old.canco_durada + :new.canco_durada
  WHERE llista_id IN (SELECT llista_con_id_llista 
                      FROM LLISTA_CONTINGUT 
                      WHERE llista_con_id_canco = :old.canco_id);
END;

CREATE OR REPLACE TRIGGER trigger_durada_llista_after_update_durada_album
  AFTER UPDATE OF album_durada
  ON ALBUM
  FOR EACH ROW
DECLARE
BEGIN
  UPDATE LLISTA
  SET llista_durada = llista_durada - :old.album_durada + :new.album_durada
  WHERE llista_id IN (SELECT llista_con_id_llista 
                      FROM LLISTA_CONTINGUT 
                      WHERE llista_con_id_canco = :old.album_id);
END;
*/
