package dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.ManagerDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Manager;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.ManagerMapper;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public Manager fromDTO(ManagerDTO managerDTO) {
        return null;
    }

    @Override
    public ManagerDTO toDTO(Manager manager) {
        EmployeeDTO employeeDTO = new EmployeeDTO(manager.getId(), manager.getName(), manager.getGender(), manager.getPhoneNumber(), manager.getDateOfBirth(), manager.getEmailAddress(),manager.getAddress(), null, manager.getStore().getId());
        return new ManagerDTO(
                employeeDTO
        );
    }


}
