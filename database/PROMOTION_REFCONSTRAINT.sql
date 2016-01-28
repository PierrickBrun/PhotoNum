--------------------------------------------------------
--  Ref Constraints for Table PROMOTION
--------------------------------------------------------

  ALTER TABLE "BROCARCL"."PROMOTION" ADD CONSTRAINT "FK_PROMOTION_COMMANDE" FOREIGN KEY ("IDCOMMANDE")
	  REFERENCES "BROCARCL"."COMMANDE" ("IDCOMMANDE") ENABLE;
