--------------------------------------------------------
--  Ref Constraints for Table PHOTO
--------------------------------------------------------

  ALTER TABLE "BROCARCL"."PHOTO" ADD CONSTRAINT "FK_PHOTO_PHOTO2_ALBUM" FOREIGN KEY ("IDALBUM")
	  REFERENCES "BROCARCL"."ALBUM" ("IDALBUM") ENABLE;
 
  ALTER TABLE "BROCARCL"."PHOTO" ADD CONSTRAINT "FK_PHOTO_PHOTO_FICHIER" FOREIGN KEY ("IDFICHIER")
	  REFERENCES "BROCARCL"."FICHIER" ("IDFICHIER") ENABLE;
