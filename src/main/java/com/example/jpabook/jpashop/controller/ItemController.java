package com.example.jpabook.jpashop.controller;

import com.example.jpabook.jpashop.domain.item.Item;
import com.example.jpabook.jpashop.domain.item.Clothes;
import com.example.jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {

        model.addAttribute("form", new ClothesForm());
        return "items/createItemForm";
    }

    @PostMapping(value = "/items/new")
    public String create(ClothesForm form) {

        Clothes clothes = new Clothes();
        clothes.setName(form.getName());
        clothes.setPrice(form.getPrice());
        clothes.setBrand(form.getBrand());
        clothes.setStockQuantity(form.getStockQuantity());
        clothes.setSize(form.getSize());
        clothes.setGender(form.getGender());
        clothes.setMaterial(form.getMaterial());

        itemService.saveItem(clothes);

        return "redirect:/items";
    }

    @GetMapping(value = "/items")
    public String list(Model model) {

        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }
}
