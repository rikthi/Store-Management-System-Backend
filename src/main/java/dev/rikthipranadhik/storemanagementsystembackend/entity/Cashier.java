package dev.rikthipranadhik.storemanagementsystembackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name="cashier")
@Getter
@Setter
public class Cashier extends Employee {
    public Cashier() {
    }

    public Cashier(Integer id, String name, String gender, String phoneNumber, LocalDate dateOfBirth, String emailAddress, String address, Employee supervisor) {
        super(id, name, gender, phoneNumber, dateOfBirth, emailAddress, address, supervisor);
    }
}
