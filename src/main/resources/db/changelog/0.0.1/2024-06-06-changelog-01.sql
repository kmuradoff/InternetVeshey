--liquibase formatted sql

-- changeset kmuradoff:1

CREATE SCHEMA IF NOT EXISTS internet_veshey;

CREATE TABLE internet_veshey.user (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    role VARCHAR(255) NOT NULL,
    residence_country VARCHAR(255),
    driver_license_number VARCHAR(255)
);

