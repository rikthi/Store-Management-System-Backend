package dev.rikthipranadhik.storemanagementsystembackend.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="salaried_employee")
@Getter

@Setter
public class SalariedEmployee extends Employee {

    @Column(name = "Salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(Integer id, String name, String gender, String phoneNumber, LocalDate dateOfBirth, String emailAddress, String address, Employee supervisor, BigDecimal salary) {
        super(id, name, gender, phoneNumber, dateOfBirth, emailAddress, address, supervisor);
        this.salary = salary;
    }

    public SalariedEmployee(BigDecimal salary) {
        this.salary = salary;
    }
}
