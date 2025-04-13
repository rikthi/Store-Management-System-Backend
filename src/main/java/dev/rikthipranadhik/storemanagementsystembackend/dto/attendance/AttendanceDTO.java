package dev.rikthipranadhik.storemanagementsystembackend.dto.attendance;

import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.EmployeeDTO;
import dev.rikthipranadhik.storemanagementsystembackend.dto.employee.ManagerDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;

import java.time.LocalDateTime;

public record AttendanceDTO (Long id, EmployeeDTO employee, EmployeeDTO manager, LocalDateTime punch_in_time, LocalDateTime punch_out_time, Boolean isVerified){

}
