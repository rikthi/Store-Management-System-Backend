package dev.rikthipranadhik.storemanagementsystembackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name="salaried_employee")
@Getter

@Setter
public class SalariedEmployee extends Employee {

    @Column(name = "Salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(BigDecimal salary) {
        this.salary = salary;
    }
}
