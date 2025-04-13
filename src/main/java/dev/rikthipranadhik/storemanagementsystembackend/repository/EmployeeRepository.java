package dev.rikthipranadhik.storemanagementsystembackend.repository;

import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findBySupervisorId(Integer supervisorId);
}
