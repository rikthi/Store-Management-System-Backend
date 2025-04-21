package dev.rikthipranadhik.storemanagementsystembackend.repository.customer;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
