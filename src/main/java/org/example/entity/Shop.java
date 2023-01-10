package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;

    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone>phones;

    @ManyToMany(cascade = CascadeType.REMOVE,mappedBy = "s")
    private List<User> user;

    public Shop( String product, String address) {
        this.product = product;
        this.address = address;
    }
}
