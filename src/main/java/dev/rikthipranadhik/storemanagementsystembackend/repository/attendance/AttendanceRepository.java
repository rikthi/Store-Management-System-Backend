package dev.rikthipranadhik.storemanagementsystembackend.repository.attendance;

import dev.rikthipranadhik.storemanagementsystembackend.entity.attendance.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Integer employeeId);
    List<Attendance> findByVerifierId(Integer verifierId);
}
