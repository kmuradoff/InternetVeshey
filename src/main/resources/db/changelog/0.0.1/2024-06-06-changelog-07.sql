--liquibase formatted sql

-- changeset kmuradoff:7
CREATE TABLE internet_veshey.car (
    id BIGSERIAL PRIMARY KEY,
    registration_number VARCHAR(255) NOT NULL,
    car_name VARCHAR(255),
    fuel_level INT,
    is_active BOOLEAN DEFAULT FALSE,
    is_locked BOOLEAN DEFAULT TRUE,
    car_brand_id BIGINT NOT NULL,
    fuel_type VARCHAR(255),
    location_id BIGINT NOT NULL,
    tariff_id BIGINT NOT NULL,
    CONSTRAINT fk_car_car_brand FOREIGN KEY (car_brand_id) REFERENCES internet_veshey.car_brand(id),
    CONSTRAINT fk_car_location FOREIGN KEY (location_id) REFERENCES internet_veshey.location(id),
    CONSTRAINT fk_car_tariff FOREIGN KEY (tariff_id) REFERENCES internet_veshey.car_tariff(id)
);
