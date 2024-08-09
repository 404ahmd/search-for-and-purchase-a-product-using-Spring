package com.ahmadibrahim.Electronic_Market.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    private int id;

    @Id
    @GeneratedValue
    private String name;

    private int amount;

    private Long price;

}
