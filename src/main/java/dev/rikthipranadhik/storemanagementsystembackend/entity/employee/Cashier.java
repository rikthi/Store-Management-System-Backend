package dev.rikthipranadhik.storemanagementsystembackend.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="cashier")
@Getter
@Setter
public class Cashier extends Employee {
    public Cashier() {
    }

}
