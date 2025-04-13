package dev.rikthipranadhik.storemanagementsystembackend.mapper.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {


    @Override
    public Employee fromDTO(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.id(),
                employeeDTO.name(),
                employeeDTO.gender(),
                employeeDTO.phoneNumber(),
                employeeDTO.dateOfBirth(),
                employeeDTO.emailAddress(),
                employeeDTO.address(),
                null
//                employeeDTO.supervisorId()                //find supervisor employee
        );
    }

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        Integer supervisorId = null;
        if (employee.getSupervisor() != null) {
            supervisorId = employee.getSupervisor().getId();
        }
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getEmailAddress(),
                employee.getAddress(),
                supervisorId
        );
    }

}
