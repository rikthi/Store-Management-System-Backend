package dev.rikthipranadhik.storemanagementsystembackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

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
