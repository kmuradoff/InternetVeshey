--liquibase formatted sql

-- changeset kmuradoff:4
CREATE TABLE internet_veshey.location (
    id BIGSERIAL PRIMARY KEY,
    latitude VARCHAR(255) NOT NULL,
    longitude VARCHAR(255) NOT NULL
);
