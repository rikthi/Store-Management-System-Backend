package dev.rikthipranadhik.storemanagementsystembackend.mapper;

import dev.rikthipranadhik.storemanagementsystembackend.dto.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;

public interface EmployeeMapper {

    Employee fromDTO(EmployeeDTO employeeDTO, Employee supervisor);
    EmployeeDTO toDTO(Employee employee);
}
