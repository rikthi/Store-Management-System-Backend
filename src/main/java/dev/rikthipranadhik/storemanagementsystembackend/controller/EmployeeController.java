package dev.rikthipranadhik.storemanagementsystembackend.controller;

import dev.rikthipranadhik.storemanagementsystembackend.dto.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/")
    public List<EmployeeDTO> listAllEmployees() {
        return employeeService.listAllEmployees()
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }

    @PostMapping("/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.createEmployee(
                employeeMapper.fromDTO(employeeDTO)
        );

        return employeeMapper.toDTO(employee);
    }


}