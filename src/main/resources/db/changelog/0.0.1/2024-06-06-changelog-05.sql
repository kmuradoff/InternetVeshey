--liquibase formatted sql

-- changeset kmuradoff:5
CREATE TABLE internet_veshey.car_tariff (
    id BIGSERIAL PRIMARY KEY,
    per_minute FLOAT NOT NULL,
    per_kilometer FLOAT NOT NULL,
    per_hour FLOAT NOT NULL,
    per_day FLOAT NOT NULL
);
