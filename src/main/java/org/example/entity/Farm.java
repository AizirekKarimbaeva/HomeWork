package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "farms")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ruler;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "f")
    private List<User> user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Animal> animals;

    public Farm( String ruler, String name) {
        this.ruler = ruler;
        this.name = name;
    }
}
