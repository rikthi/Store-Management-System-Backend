package dev.rikthipranadhik.storemanagementsystembackend.service.impl;

import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.repository.EmployeeRepository;
import dev.rikthipranadhik.storemanagementsystembackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

     private final EmployeeRepository employeeRepository;

     public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
         this.employeeRepository = employeeRepository;
     }

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getId() != null){
            throw new IllegalArgumentException("Employee Already has an ID");
        }

        if (employee.getName() == null || employee.getName().isEmpty()){
            throw new IllegalArgumentException("Employee Name is Empty");
        }

        return employeeRepository.save(new Employee(
                null,
                employee.getName(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getEmailAddress(),
                employee.getAddress(),
                employee.getSupervisor()
        ));
    }


}
