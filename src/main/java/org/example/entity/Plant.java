package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "plants")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    private String utility;

    @OneToOne(mappedBy = "plant")
    private Animal animal;

    public Plant(String type, String utility) {
        this.type = type;
        this.utility = utility;
    }
}
