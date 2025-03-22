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
public class HourlyEmployee {


    @Id
    @Column(name = "Employee_ID", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @Column(name = "Pay_Scale", precision = 10, scale = 2)
    private BigDecimal payScale;

    public HourlyEmployee() {
    }

    public HourlyEmployee(Integer id, Employee employee, BigDecimal payScale) {
        this.id = id;
        this.employee = employee;
        this.payScale = payScale;
    }
}
