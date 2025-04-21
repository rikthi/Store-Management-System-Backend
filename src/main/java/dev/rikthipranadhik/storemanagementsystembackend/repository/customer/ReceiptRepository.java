package dev.rikthipranadhik.storemanagementsystembackend.repository.customer;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Customer.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
