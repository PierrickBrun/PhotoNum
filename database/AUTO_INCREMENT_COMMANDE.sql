--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_COMMANDE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_COMMANDE" 
before insert on commande
for each row
begin
    select commande_id_seq.nextval into :new.idcommande from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_COMMANDE" ENABLE;
