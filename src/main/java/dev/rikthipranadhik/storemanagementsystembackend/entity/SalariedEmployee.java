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
public class SalariedEmployee {

    @Id
    @Column(name = "Employee_ID", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @Column(name = "Salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(Integer id, Employee employee, BigDecimal salary) {
        this.id = id;
        this.employee = employee;
        this.salary = salary;
    }
}
