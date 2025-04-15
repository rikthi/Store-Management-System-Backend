package dev.rikthipranadhik.storemanagementsystembackend.service.attendance;

import dev.rikthipranadhik.storemanagementsystembackend.entity.attendance.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> listAllAttendance();
    Attendance createAttendance(Attendance attendance, Integer employeeId, Integer verifierId);
    List<Attendance> getAllAttendanceByEmployeeId(Integer employeeId);
    List<Attendance> getAllAttendanceBySupervisorId(Integer supervisorId);
}
