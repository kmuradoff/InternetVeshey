--liquibase formatted sql

-- changeset kmuradoff:6
CREATE TABLE internet_veshey.car_model (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    engine VARCHAR(255) NOT NULL,
    transmission VARCHAR(255) NOT NULL,
    color VARCHAR(255),
    car_brand_id BIGINT NOT NULL,
    CONSTRAINT fk_car_model_car_brand FOREIGN KEY (car_brand_id) REFERENCES internet_veshey.car_brand(id)
);
