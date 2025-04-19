package dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.impl;


import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.HourlyEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.SalariedEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.SalariedEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.SalariedEmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class SalariedEmployeeMapperImpl implements SalariedEmployeeMapper {


    @Override
    public SalariedEmployee fromDTO(SalariedEmployeeDTO salariedEmployeeDTO) {
        return null;
    }

    @Override
    public SalariedEmployeeDTO toDTO(SalariedEmployee salariedEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(salariedEmployee.getId(), salariedEmployee.getName(), salariedEmployee.getGender(), salariedEmployee.getPhoneNumber(), salariedEmployee.getDateOfBirth(), salariedEmployee.getEmailAddress(),salariedEmployee.getAddress(), salariedEmployee.getSupervisor().getId(), salariedEmployee.getStore().getId());
        return new SalariedEmployeeDTO(
                employeeDTO,
                salariedEmployee.getSalary()
        );
    }
}
