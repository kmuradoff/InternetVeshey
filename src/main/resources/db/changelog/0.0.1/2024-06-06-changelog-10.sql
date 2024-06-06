--liquibase formatted sql

-- changeset kmuradoff:10
CREATE TABLE internet_veshey.car_brand_to_car_model (
    car_brand_id BIGINT NOT NULL,
    car_model_id BIGINT NOT NULL,
    PRIMARY KEY (car_brand_id, car_model_id),
    CONSTRAINT fk_car_brand_to_car_model_brand FOREIGN KEY (car_brand_id) REFERENCES internet_veshey.car_brand(id),
    CONSTRAINT fk_car_brand_to_car_model_model FOREIGN KEY (car_model_id) REFERENCES internet_veshey.car_model(id)
);
