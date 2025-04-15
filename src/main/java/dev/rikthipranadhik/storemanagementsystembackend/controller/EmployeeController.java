package dev.rikthipranadhik.storemanagementsystembackend.controller;

import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.service.employee.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "{storeId}/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("")
    public List<EmployeeDTO> listAllEmployees(@PathVariable("storeId") Long storeId) {
        return employeeService.listAllEmployees(storeId)
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("storeId") Long storeId) {
        Employee employee = employeeMapper.fromDTO(employeeDTO);
        Integer supervisorId = employeeDTO.supervisorId();
        Employee finalEmployee = employeeService.createEmployee(employee, supervisorId, storeId);
        return ResponseEntity.ok(employeeMapper.toDTO(finalEmployee));
    }


}