package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.payment.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
