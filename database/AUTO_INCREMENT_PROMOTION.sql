--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_PROMOTION
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_PROMOTION" 
before insert on promotion
for each row
begin
    select promotion_id_seq.nextval into :new.idpromotion from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_PROMOTION" ENABLE;
