package dev.rikthipranadhik.storemanagementsystembackend.entity.user;

import dev.rikthipranadhik.storemanagementsystembackend.entity.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name= "username")
    private String username;

    @Column(name= "hashedPassword")
    private String password;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;


    public User (){

    }

    public User(Long id,  String username, String password, String email, Employee employee){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.employee = employee;
    }




}
