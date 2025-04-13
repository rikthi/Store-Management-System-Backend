package dev.rikthipranadhik.storemanagementsystembackend.service;


import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.repository.EmployeeRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees();
    Employee createEmployee(Employee employee);


}
