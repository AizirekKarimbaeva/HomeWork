package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employee;

    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Driver> drivers;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "c")
    private List<User> user;

    public Company( String employee, String address) {
        this.employee = employee;
        this.address = address;
    }
}

