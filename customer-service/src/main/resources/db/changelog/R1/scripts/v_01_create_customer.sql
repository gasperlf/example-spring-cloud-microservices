--liquibase formatted sql

--changeset liquidbase:V_01
create TABLE customer(
 id INTEGER NOT NULL AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 last_name VARCHAR(100) NOT NULL,
 email VARCHAR(100) NOT NULL,
 cellphone_number VARCHAR(100) NOT NULL,
 CONSTRAINT customer_PK PRIMARY KEY (id)
)