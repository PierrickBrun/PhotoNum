--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_CLIENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_CLIENT" 
before insert on client
for each row
begin
    select client_id_seq.nextval into :new.idclient from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_CLIENT" ENABLE;
