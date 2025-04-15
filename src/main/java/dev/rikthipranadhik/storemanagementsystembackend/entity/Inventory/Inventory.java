package dev.rikthipranadhik.storemanagementsystembackend.entity.Inventory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Inventory")
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "inventory_id")
    private Long id;


}
