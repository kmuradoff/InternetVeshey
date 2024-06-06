--liquibase formatted sql

-- changeset kmuradoff:11
CREATE TABLE internet_veshey.user_to_paymentcards (
    user_id BIGINT NOT NULL,
    card_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, card_id),
    CONSTRAINT fk_user_to_paymentcards_user FOREIGN KEY (user_id) REFERENCES internet_veshey.user(id),
    CONSTRAINT fk_user_to_paymentcards_card FOREIGN KEY (card_id) REFERENCES internet_veshey.payment_card(id)
);
