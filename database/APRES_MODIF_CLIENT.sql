--------------------------------------------------------
--  DDL for Trigger APRES_MODIF_CLIENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."APRES_MODIF_CLIENT" 
AFTER UPDATE ON CLIENT FOR EACH ROW
BEGIN
  IF :NEW.ACTIF = 0 THEN
    UPDATE FICHIER SET PARTAGE = 0 WHERE IDCLIENT = :NEW.IDCLIENT; 
  END IF;
END;
/
ALTER TRIGGER "BROCARCL"."APRES_MODIF_CLIENT" ENABLE;
