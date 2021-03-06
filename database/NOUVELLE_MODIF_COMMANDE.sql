--------------------------------------------------------
--  DDL for Trigger NOUVELLE_MODIF_COMMANDE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."NOUVELLE_MODIF_COMMANDE" 
AFTER INSERT OR UPDATE ON COMMANDE FOR EACH ROW
BEGIN
  IF (:NEW.STATUT = 'en cours') THEN
    CREATION_PROMOTION(:NEW.IDCOMMANDE,:NEW.PRIXTOTAL);
  END IF;
  NULL;
END;
/
ALTER TRIGGER "BROCARCL"."NOUVELLE_MODIF_COMMANDE" ENABLE;
