

CREATE OR REPLACE TRIGGER TR_ART_GRUP_DATACREACIO
BEFORE INSERT ON ART_GRUP
FOR EACH ROW
BEGIN
    if :NEW.ARTG_DATA_CREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20000, 'La data de creacio del grup no pot ser superior a la data actual.');
        end if;
end;

CREATE OR REPLACE TRIGGER TR_ART_IND_DATANAIX
BEFORE INSERT ON ART_IND
FOR EACH ROW
BEGIN
    if :NEW.ARTI_DATA_NAIXAMENT => sysdate then
        RAISE_APPLICATION_ERROR(-20001, 'La data de naixement de l''artista no pot ser superior o igual a la data actual');
        end if;
end;

CREATE OR REPLACE TRIGGER TR_H_GRUP_DATAINICI
BEFORE INSERT ON H_GRUP
FOR EACH ROW
BEGIN
    if :NEW.HG_DATA_INICI > sysdate then
        RAISE_APPLICATION_ERROR(-20002, 'La data d''inici del grup no pot ser superior a la data actual.');
        end if;
end;

CREATE OR REPLACE TRIGGER TR_CANSO_ANYCREACIO
BEFORE INSERT ON CANÇO
FOR EACH ROW
BEGIN
    if :NEW.CAN_ANY_CREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20003, 'La data de creacio de la canco no pot ser superior a la data actual.');
        end if;
end;

CREATE OR REPLACE TRIGGER TR_ALBUM_ANYCREACIO
BEFORE INSERT ON ALBUM
FOR EACH ROW
BEGIN
    if :NEW.ALB_ANY_CREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20004, 'L''any de creacio de l''album no pot ser superior al actual.');
        end if;
end;
