--liquibase formatted sql

--changeset liquidbase:V_1.0.0_ms_ss_01
insert into application (name,type, state)values ('financial','microservice',1);