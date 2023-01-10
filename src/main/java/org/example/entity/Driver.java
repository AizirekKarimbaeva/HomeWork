package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int age;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "car_id")
    private Car car;

    public Driver(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "phone_id")
    private Phone phone;
}

