package dev.rikthipranadhik.storemanagementsystembackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="clerk")
@Getter
@Setter
public class Clerk {
    @Id
    @Column(name = "Employee_ID", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    public Clerk() {
    }

    public Clerk(Integer id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }
}
