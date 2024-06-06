--liquibase formatted sql

-- changeset kmuradoff:8
CREATE TABLE internet_veshey.invoice (
    id BIGSERIAL PRIMARY KEY,
    amount FLOAT NOT NULL,
    currency VARCHAR(255) NOT NULL,
    is_paid BOOLEAN NOT NULL,
    name VARCHAR(255),
    description TEXT,
    payment_card_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_invoice_payment_card FOREIGN KEY (payment_card_id) REFERENCES internet_veshey.payment_card(id),
    CONSTRAINT fk_invoice_user FOREIGN KEY (user_id) REFERENCES internet_veshey.user(id)
);
