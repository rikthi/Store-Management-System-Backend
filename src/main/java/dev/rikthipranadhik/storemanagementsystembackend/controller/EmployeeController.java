package dev.rikthipranadhik.storemanagementsystembackend.controller;

import dev.rikthipranadhik.storemanagementsystembackend.dto.Params;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.HourlyEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.SalariedEmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.HourlyEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.SalariedEmployee;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.HourlyEmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.SalariedEmployeeMapper;
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
    private final SalariedEmployeeMapper salariedEmployeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, HourlyEmployeeMapper hourlyEmployeeMapper, SalariedEmployeeMapper salariedEmployeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.hourlyEmployeeMapper = hourlyEmployeeMapper;
        this.salariedEmployeeMapper = salariedEmployeeMapper;
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

    public List<HourlyEmployeeDTO> listAllHourlyEmployees(@PathVariable("storeId") Long storeId){
        return employeeService.listAllHourlyEmployees(storeId).stream().map(hourlyEmployeeMapper::toDTO).toList();
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

    @GetMapping("/listHourlyEmployees")
    List<HourlyEmployeeDTO> listHourlyEmployees(@PathVariable("storeId") Long storeId) {
        return employeeService.listAllHourlyEmployees(storeId)
                .stream()
                .map(hourlyEmployeeMapper::toDTO)
                .toList();
    }

    @GetMapping("/listSalariedEmployees")
    List<SalariedEmployeeDTO> listSalariedEmployees(@PathVariable("storeId") Long storeId) {
        return employeeService.listAllSalariedEmployees(storeId)
                .stream()
                .map(salariedEmployeeMapper::toDTO)
                .toList();
    }

    @PostMapping("/create/salariedEmployee")
    public ResponseEntity<SalariedEmployeeDTO> createSalariedEmployee(@RequestBody SalariedEmployeeDTO salariedEmployeeDTO, @PathVariable("storeId") Long storeId) {
        EmployeeDTO employeeDTO = salariedEmployeeDTO.employee();
        Employee employee = createEmployee(employeeDTO, storeId);
        SalariedEmployee salariedEmployee= new SalariedEmployee(
                employee.getId(),
                employee.getName(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getEmailAddress(),
                employee.getAddress(),
                employee.getSupervisor(),
                employee.getStore(),
                salariedEmployeeDTO.salary()
        );

        return ResponseEntity.ok(salariedEmployeeMapper.toDTO(employeeService.createSalariedEmployee(salariedEmployee)));
    }

}