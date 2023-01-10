package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;

    private String manufacture;
    @OneToOne(mappedBy = "car")
    private Driver driver;

    public Car(String brand, String manufacture) {
        this.brand = brand;
        this.manufacture = manufacture;
    }
}

