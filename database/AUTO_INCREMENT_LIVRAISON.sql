--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_LIVRAISON
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_LIVRAISON" 
before insert on livraison
for each row
begin
    select livraison_id_seq.nextval into :new.idlivraison from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_LIVRAISON" ENABLE;
