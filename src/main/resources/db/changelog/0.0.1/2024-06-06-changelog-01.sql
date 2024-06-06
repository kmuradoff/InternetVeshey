--liquibase formatted sql

-- changeset kmuradoff:1

CREATE SCHEMA IF NOT EXISTS internet_veshey;

CREATE TABLE internet_veshey.user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
