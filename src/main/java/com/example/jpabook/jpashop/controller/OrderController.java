package com.example.jpabook.jpashop.controller;

import com.example.jpabook.jpashop.domain.Member;
import com.example.jpabook.jpashop.service.ItemService;
import com.example.jpabook.jpashop.service.MemberService;
import com.example.jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

//    @GetMapping(value = "/order")
//    public String createForm(Model model) {
//
//        List<Member> members = memberService.findMember();
//
//    }
}
