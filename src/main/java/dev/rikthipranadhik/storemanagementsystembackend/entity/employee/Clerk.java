package dev.rikthipranadhik.storemanagementsystembackend.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="clerk")
@Getter
@Setter
public class Clerk extends Employee{

    public Clerk() {
    }

}
