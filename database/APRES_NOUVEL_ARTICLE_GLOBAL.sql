--------------------------------------------------------
--  DDL for Trigger APRES_NOUVEL_ARTICLE_GLOBAL
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."APRES_NOUVEL_ARTICLE_GLOBAL" 
AFTER INSERT ON ARTICLE
BEGIN
  UPDATE_PRIX_COMMANDES();
END;
/
ALTER TRIGGER "BROCARCL"."APRES_NOUVEL_ARTICLE_GLOBAL" ENABLE;
