package com.ctse.product.model;


import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private float price;
    private int quantity;
    private String category;
    private int isDeliveryAvailable;
}
