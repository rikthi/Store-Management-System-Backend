package dev.rikthipranadhik.storemanagementsystembackend.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name= "hourly_employee")
@Getter
@Setter
public class HourlyEmployee extends Employee {


    @Column(name = "Pay_Scale", precision = 10, scale = 2)
    private BigDecimal payScale;

    public HourlyEmployee() {
    }

    public HourlyEmployee(BigDecimal payScale) {
        this.payScale = payScale;
    }
}
