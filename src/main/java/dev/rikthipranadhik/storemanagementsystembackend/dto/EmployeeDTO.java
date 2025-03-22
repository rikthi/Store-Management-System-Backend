package dev.rikthipranadhik.storemanagementsystembackend.dto;

import java.time.LocalDate;

public record EmployeeDTO(
        int id,
        String name, String gender, String phoneNumber, LocalDate dateOfBirth, String emailAddress, String address, Integer supervisorId
) {

}
