--------------------------------------------------------
--  Ref Constraints for Table ALBUM
--------------------------------------------------------

  ALTER TABLE "BROCARCL"."ALBUM" ADD CONSTRAINT "FK_ALBUM_ALBUMCLIE_CLIENT" FOREIGN KEY ("IDCLIENT")
	  REFERENCES "BROCARCL"."CLIENT" ("IDCLIENT") ENABLE;
