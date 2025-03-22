package dev.rikthipranadhik.storemanagementsystembackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name= "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Employee_ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Lob
    @Column(name = "Gender", columnDefinition = "ENUM('Male', 'Female', 'Other')")
    private String gender;

    @Column(name = "Phone_Number", length = 20)
    private String phoneNumber;

    @Column(name = "Date_of_Birth")
    private LocalDate dateOfBirth;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Lob
    @Column(name = "Address", columnDefinition = "TEXT")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "Supervisor_ID")
    private Employee supervisor;

    public Employee() {
    }

    public Employee(int id, String name, String gender, String phoneNumber, LocalDate dateOfBirth, String emailAddress, String address, Employee supervisor) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.address = address;
        this.supervisor = supervisor;
    }


}
