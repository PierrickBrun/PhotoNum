--------------------------------------------------------
--  Ref Constraints for Table LIVRAISON
--------------------------------------------------------

  ALTER TABLE "BROCARCL"."LIVRAISON" ADD CONSTRAINT "FK_LIVRAISO_LIVRAISON_ARTICLE" FOREIGN KEY ("IDARTICLE")
	  REFERENCES "BROCARCL"."ARTICLE" ("IDARTICLE") ENABLE;
