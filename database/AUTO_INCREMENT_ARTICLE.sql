--------------------------------------------------------
--  DDL for Trigger AUTO_INCREMENT_ARTICLE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BROCARCL"."AUTO_INCREMENT_ARTICLE" 
before insert on article
for each row
begin
    select article_id_seq.nextval into :new.idarticle from dual;
end;
/
ALTER TRIGGER "BROCARCL"."AUTO_INCREMENT_ARTICLE" ENABLE;
