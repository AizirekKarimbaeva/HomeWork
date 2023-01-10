package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;

    private int price;
   @OneToOne(cascade = CascadeType.PERSIST)
    private Shop shop;

    public Phone(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }
}


