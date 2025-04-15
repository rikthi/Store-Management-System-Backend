package dev.rikthipranadhik.storemanagementsystembackend.service.attendance.impl;


import dev.rikthipranadhik.storemanagementsystembackend.entity.attendance.Attendance;
import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import dev.rikthipranadhik.storemanagementsystembackend.repository.attendance.AttendanceRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.employee.EmployeeRepository;
import dev.rikthipranadhik.storemanagementsystembackend.service.attendance.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Attendance> listAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance createAttendance(Attendance attendance, Integer employeeId, Integer verifierId) {
        if (attendance.getId() != null) {
            throw new IllegalArgumentException("New attendance ID has to be null");
        }
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if  (employee == null) {
            throw new IllegalArgumentException("Employee with id: " + employeeId + " does not exist");
        }
        attendance.setEmployee(employee);
        attendance.setVerifier(employeeRepository.findById(verifierId).orElse(null));
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendanceByEmployeeId(Integer employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Attendance> getAllAttendanceBySupervisorId(Integer verifierId) {
        return attendanceRepository.findByVerifierId(verifierId);
    }
}
