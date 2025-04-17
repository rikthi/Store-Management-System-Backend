package dev.rikthipranadhik.storemanagementsystembackend.service.employee;


import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees(Long storeId);
    Employee createEmployee(Employee employee, Integer supervisorId, Long storeId);
    HourlyEmployee createHourlyEmployee(HourlyEmployee hourlyEmployee);
    Employee getEmployeeById(Long storeId, Integer id);
}
