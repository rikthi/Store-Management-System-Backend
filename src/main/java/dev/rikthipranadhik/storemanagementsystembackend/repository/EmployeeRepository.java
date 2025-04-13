package dev.rikthipranadhik.storemanagementsystembackend.repository;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.SalariedEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findBySupervisorId(Integer supervisorId);
}
