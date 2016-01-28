--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_PRESTATAIRE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_PRESTATAIRE" 
before insert on prestataire
for each row
begin
    select prestataire_id_seq.nextval into :new.idprestataire from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_PRESTATAIRE" ENABLE;
