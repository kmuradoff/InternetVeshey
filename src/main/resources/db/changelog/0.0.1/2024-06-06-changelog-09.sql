--liquibase formatted sql

-- changeset kmuradoff:9
CREATE TABLE internet_veshey.ride (
    id BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP,
    distance FLOAT NOT NULL,
    car_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    invoice_id BIGINT NOT NULL,
    CONSTRAINT fk_ride_car FOREIGN KEY (car_id) REFERENCES internet_veshey.car(id),
    CONSTRAINT fk_ride_user FOREIGN KEY (user_id) REFERENCES internet_veshey.user(id),
    CONSTRAINT fk_ride_invoice FOREIGN KEY (invoice_id) REFERENCES internet_veshey.invoice(id)
);
