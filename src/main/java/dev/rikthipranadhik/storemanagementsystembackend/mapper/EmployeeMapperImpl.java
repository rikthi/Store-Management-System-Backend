package dev.rikthipranadhik.storemanagementsystembackend.mapper;

import dev.rikthipranadhik.storemanagementsystembackend.dto.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import org.springframework.scheduling.config.Task;

public class EmployeeMapperImpl implements EmployeeMapper {


    @Override
    public Employee fromDTO(EmployeeDTO employeeDTO, Employee supervisor) {
        return new Employee(
                employeeDTO.id(),
                employeeDTO.name(),
                employeeDTO.gender(),
                employeeDTO.phoneNumber(),
                employeeDTO.dateOfBirth(),
                employeeDTO.emailAddress(),
                employeeDTO.address(),
                supervisor
                //find supervisor employee
        );
    }

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        return null;
    }

}
