package dev.rikthipranadhik.storemanagementsystembackend.controller;

import dev.rikthipranadhik.storemanagementsystembackend.dto.Params;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.HourlyEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.HourlyEmployeeMapper;
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
    private final HourlyEmployeeMapper hourlyEmployeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, HourlyEmployeeMapper hourlyEmployeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.hourlyEmployeeMapper = hourlyEmployeeMapper;
    }

    @PostMapping("/create/hourlyEmployee")
    public ResponseEntity<HourlyEmployeeDTO> createHourlyEmployee(@RequestBody HourlyEmployeeDTO hourlyEmployeeDTO, @PathVariable("storeId") Long storeId) {
        EmployeeDTO employeeDTO = hourlyEmployeeDTO.employee();
        Employee employee = createEmployee(employeeDTO, storeId);
        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                employee.getId(),
                employee.getName(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getEmailAddress(),
                employee.getAddress(),
                employee.getSupervisor(),
                employee.getStore(),
                hourlyEmployeeDTO.payScale()
        );

        return ResponseEntity.ok(hourlyEmployeeMapper.toDTO(employeeService.createHourlyEmployee(hourlyEmployee)));
    }

    @GetMapping("")
    public List<EmployeeDTO> listAllEmployees(@PathVariable("storeId") Long storeId) {
        return employeeService.listAllEmployees(storeId)
                .stream()
                .map(employeeMapper::toDTO)
                .toList();
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("storeId") Long storeId) {
        Employee employee = employeeMapper.fromDTO(employeeDTO);
        Integer supervisorId = employeeDTO.supervisorId();
        return employeeService.createEmployee(employee, supervisorId, storeId);
    }

    @PostMapping("/getEmployee")
    public  EmployeeDTO getEmployee(@RequestBody Params params , @PathVariable("storeId") Long storeId) {

        return employeeMapper.toDTO(employeeService.getEmployeeById(storeId, params.params()));
    }

}