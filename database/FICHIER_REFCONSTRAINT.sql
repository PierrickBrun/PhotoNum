--------------------------------------------------------
--  Ref Constraints for Table FICHIER
--------------------------------------------------------

  ALTER TABLE "BROCARCL"."FICHIER" ADD CONSTRAINT "FK_FICHIER_TELECHARG_CLIENT" FOREIGN KEY ("IDCLIENT")
	  REFERENCES "BROCARCL"."CLIENT" ("IDCLIENT") ENABLE;
