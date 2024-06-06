--liquibase formatted sql

-- changeset kmuradoff:4
CREATE TABLE internet_veshey.location (
    id BIGSERIAL PRIMARY KEY,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL
);
