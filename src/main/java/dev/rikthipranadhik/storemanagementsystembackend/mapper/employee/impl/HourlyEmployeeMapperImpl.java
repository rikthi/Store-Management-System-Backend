package dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.HourlyEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.HourlyEmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class HourlyEmployeeMapperImpl implements HourlyEmployeeMapper {


    @Override
    public HourlyEmployee fromDTO(HourlyEmployeeDTO hourlyEmployeeDTO) {
        return null;
//        EmployeeDTO employee = hourlyEmployeeDTO.employee();
//        return new HourlyEmployee(
//                employee.id(),
//                employee.name(),
//                employee.gender(),
//                employee.phoneNumber(),
//                employee.dateOfBirth(),
//                employee.emailAddress(),
//                employee.address(),
//                employee.supervisorId(),
//                employee.storeId(),
//                hourlyEmployeeDTO.payScale()
//        )

    }

    @Override
    public HourlyEmployeeDTO toDTO(HourlyEmployee hourlyEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(hourlyEmployee.getId(), hourlyEmployee.getName(), hourlyEmployee.getGender(), hourlyEmployee.getPhoneNumber(), hourlyEmployee.getDateOfBirth(), hourlyEmployee.getEmailAddress(),hourlyEmployee.getAddress(), hourlyEmployee.getSupervisor().getId(), hourlyEmployee.getStore().getId());
        return new HourlyEmployeeDTO(
                employeeDTO,
                hourlyEmployee.getPayScale()
        );
    }
}
