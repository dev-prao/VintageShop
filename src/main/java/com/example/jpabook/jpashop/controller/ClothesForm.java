package com.example.jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothesForm {

    private Long id;

    private String name;
    private String brand;
    private int price;
    private int stockQuantity;

    private int size;
    private String material;
}
