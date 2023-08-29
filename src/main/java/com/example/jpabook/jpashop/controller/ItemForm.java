package com.example.jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {

    private Long id;

    private String name;
    private String brand;
    private int price;
    private int stockQuantity;

    private String gender;
    private String size;
    private String material;
    private int statusScore;
}
