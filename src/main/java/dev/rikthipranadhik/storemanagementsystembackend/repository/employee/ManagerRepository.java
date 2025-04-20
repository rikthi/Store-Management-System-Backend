package dev.rikthipranadhik.storemanagementsystembackend.repository.employee;

import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
