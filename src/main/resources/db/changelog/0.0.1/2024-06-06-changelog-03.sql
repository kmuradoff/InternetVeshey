--liquibase formatted sql

-- changeset kmuradoff:3
CREATE TABLE internet_veshey.car_brand (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    brand_logo BYTEA,
    color VARCHAR(255)
);
