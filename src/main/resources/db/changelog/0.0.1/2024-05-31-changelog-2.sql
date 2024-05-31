-- Вставка тестовых данных для устройств
INSERT INTO internet_veshey.device (device_type, status, location) VALUES
('TEMPERATURE_SENSOR', TRUE, 'Living Room'),
('TEMPERATURE_SENSOR', FALSE, 'Kitchen'),
('PRESSURE_SENSOR', TRUE, 'Basement'),
('PRESSURE_SENSOR', FALSE, 'Attic');

-- Вставка тестовых данных для датчиков температуры
INSERT INTO internet_veshey.temperature_sensor (id, last_temperature, last_measurement_time) VALUES
((SELECT id FROM internet_veshey.device WHERE location = 'Living Room'), 22.5, '2024-05-31 10:00:00'),
((SELECT id FROM internet_veshey.device WHERE location = 'Kitchen'), 18.7, '2024-05-30 08:30:00');

-- Вставка тестовых данных для датчиков давления
INSERT INTO internet_veshey.pressure_sensor (id, last_pressure, last_measurement_time) VALUES
((SELECT id FROM internet_veshey.device WHERE location = 'Basement'), 1015.5, '2024-05-31 09:00:00'),
((SELECT id FROM internet_veshey.device WHERE location = 'Attic'), 1013.2, '2024-05-30 07:45:00');
