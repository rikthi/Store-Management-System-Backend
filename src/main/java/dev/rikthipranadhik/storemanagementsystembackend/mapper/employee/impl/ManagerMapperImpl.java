package dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.ManagerDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Manager;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.ManagerMapper;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapperImpl implements ManagerMapper {

    private final EmployeeMapper employeeMapper;

    public ManagerMapperImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }
    @Override
    public Manager fromDTO(ManagerDTO managerDTO) {
        return new Manager(
        );
    }

    @Override
    public ManagerDTO toDTO(Manager manager) {
        return null;
    }


}
