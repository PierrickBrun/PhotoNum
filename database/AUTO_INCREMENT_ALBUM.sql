--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_ALBUM
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_ALBUM" 
before insert on album
for each row
begin
    select album_id_seq.nextval into :new.idalbum from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_ALBUM" ENABLE;
