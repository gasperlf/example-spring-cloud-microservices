--liquibase formatted sql

--changeset liquidbase:V_1.0.0_ms_ss_00
create TABLE application(
 id INTEGER NOT NULL AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 type VARCHAR(100) NOT NULL,
 state integer NOT NULL,
 CONSTRAINT application PRIMARY KEY (id)
)