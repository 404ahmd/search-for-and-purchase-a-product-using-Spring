package com.ahmadibrahim.Electronic_Market.DTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyProductRequest {

    private String name;

    private int quantity;
}
