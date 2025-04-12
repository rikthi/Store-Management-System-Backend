package dev.rikthipranadhik.storemanagementsystembackend.repository;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findById(int id);
}
