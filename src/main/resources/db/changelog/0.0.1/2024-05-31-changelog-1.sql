CREATE SCHEMA IF NOT EXISTS internet_veshey;

CREATE TABLE IF NOT EXISTS internet_veshey.device (
    id SERIAL PRIMARY KEY,
    device_type VARCHAR(50) NOT NULL,
    status BOOLEAN NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS internet_veshey.temperature_sensor (
    id INT PRIMARY KEY,
    last_temperature FLOAT NOT NULL,
    last_measurement_time TIMESTAMP NOT NULL,
    CONSTRAINT fk_temperature_device FOREIGN KEY (id) REFERENCES internet_veshey.device(id)
);

CREATE TABLE IF NOT EXISTS internet_veshey.pressure_sensor (
    id INT PRIMARY KEY,
    last_pressure FLOAT NOT NULL,
    last_measurement_time TIMESTAMP NOT NULL,
    CONSTRAINT fk_pressure_device FOREIGN KEY (id) REFERENCES internet_veshey.device(id)
);