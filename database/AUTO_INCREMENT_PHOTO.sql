--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_PHOTO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_PHOTO" 
before insert on photo
for each row
begin
    select photo_id_seq.nextval into :new.idphoto from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_PHOTO" ENABLE;
