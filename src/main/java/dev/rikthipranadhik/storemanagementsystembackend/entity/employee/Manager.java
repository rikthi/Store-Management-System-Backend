package dev.rikthipranadhik.storemanagementsystembackend.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="manager")
@Getter
@Setter
public class Manager extends Employee {

    public Manager() {
    }

}
