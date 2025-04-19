package dev.rikthipranadhik.storemanagementsystembackend.service.employee;


import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.SalariedEmployee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees(Long storeId);
    Employee createEmployee(Employee employee, Integer supervisorId, Long storeId);

    SalariedEmployee createSalariedEmployee(SalariedEmployee salariedEmployee);

    List<SalariedEmployee> listAllSalariedEmployees(Long storeId);

    List<HourlyEmployee> listAllHourlyEmployees(Long storeId);

    HourlyEmployee createHourlyEmployee(HourlyEmployee hourlyEmployee);
    Employee getEmployeeById(Long storeId, Integer id);
}
