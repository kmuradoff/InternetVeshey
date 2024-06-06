--liquibase formatted sql

-- changeset kmuradoff:2
CREATE TABLE internet_veshey.payment_card (
    id BIGSERIAL PRIMARY KEY,
    card_brand VARCHAR(255) NOT NULL,
    card_number VARCHAR(255) NOT NULL,
    valid_thru DATE NOT NULL,
    card_holder VARCHAR(255) NOT NULL,
    cvc INT NOT NULL
);
