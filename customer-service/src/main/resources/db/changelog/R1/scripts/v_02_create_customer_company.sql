--liquibase formatted sql

--changeset liquidbase:V_02
create TABLE customer_company(
 id INTEGER NOT NULL AUTO_INCREMENT,
 customer_id INTEGER NOT NULL,
 company VARCHAR(5) NOT NULL,
 start_date DATETIME NOT NULL,
 state INTEGER(1) NOT NULL,
 end_date DATETIME ,
 created_by VARCHAR(50) NOT NULL,
 creation_date DATETIME NOT NULL ,
 last_modified_by VARCHAR(50) NOT NULL,
 last_modified_date DATETIME NOT NULL ,
 CONSTRAINT customer_company_PK PRIMARY KEY (id)
)