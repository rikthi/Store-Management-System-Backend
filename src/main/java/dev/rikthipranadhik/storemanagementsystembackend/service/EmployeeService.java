package dev.rikthipranadhik.storemanagementsystembackend.service;


import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees();
    Employee createEmployee(Employee employee);


}
