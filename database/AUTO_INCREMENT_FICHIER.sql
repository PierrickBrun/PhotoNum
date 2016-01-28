--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_FICHIER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_FICHIER" 
before insert on fichier
for each row
begin
    select fichier_id_seq.nextval into :new.idfichier from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_FICHIER" ENABLE;
