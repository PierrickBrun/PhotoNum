--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_FORMAT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_FORMAT" 
before insert on format
for each row
begin
    select format_id_seq.nextval into :new.idformat from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_FORMAT" ENABLE;
