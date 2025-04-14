package dev.rikthipranadhik.storemanagementsystembackend.service.employee;


import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees();
    Employee createEmployee(Employee employee, Integer supervisorId);


}
