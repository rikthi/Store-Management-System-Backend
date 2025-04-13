package dev.rikthipranadhik.storemanagementsystembackend.mapper.attendance.impl;

import dev.rikthipranadhik.storemanagementsystembackend.dto.attendance.AttendanceDTO;
import dev.rikthipranadhik.storemanagementsystembackend.entity.attendance.Attendance;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.attendance.AttendanceMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.EmployeeMapper;
import dev.rikthipranadhik.storemanagementsystembackend.mapper.employee.ManagerMapper;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapperImpl implements AttendanceMapper {

    private final EmployeeMapper employeeMapper;

    public AttendanceMapperImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Attendance fromDTO(AttendanceDTO attendanceDTO) {
        return new Attendance(
                attendanceDTO.id(),
                employeeMapper.fromDTO(attendanceDTO.employee()),
                employeeMapper.fromDTO(attendanceDTO.manager()),
                attendanceDTO.punch_in_time(),
                attendanceDTO.punch_out_time(),
                attendanceDTO.isVerified()
        );
    }

    @Override
    public AttendanceDTO toDTO(Attendance attendance) {
        return new AttendanceDTO(
                attendance.getId(),
                employeeMapper.toDTO(attendance.getEmployee()),
                employeeMapper.toDTO(attendance.getVerifier()),
                attendance.getPunchInTime(),
                attendance.getPunchOutTime(),
                attendance.getIsVerified()
        );
    }
}
