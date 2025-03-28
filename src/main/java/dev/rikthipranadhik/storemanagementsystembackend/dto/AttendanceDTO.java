package dev.rikthipranadhik.storemanagementsystembackend.dto;

import java.time.Instant;

public record AttendanceDTO(Integer id, int hourlyEmployeeID, int managerID, Boolean isVerified, Instant punchInTime, Instant punchOutTime) {
}
