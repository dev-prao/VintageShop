package com.example.jpabook.jpashop.service;

import com.example.jpabook.jpashop.domain.item.Item;
import com.example.jpabook.jpashop.domain.item.Top;
import com.example.jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품_업데이트() throws Exception { //수정필요
//        //given
//        Top top = new Top();
//        top.setName("무지 긴팔티");
//        itemService.saveItem(top);
//
//        //when
//        itemService.updateItem(top.getId(), "스트라이프 긴팔티",
//                                                "무신사", 10000, 10, "men", "cotton");
//
//        Item findOne = itemService.findOne(top.getId());
//
//        //then
//        Assertions.assertThat(findOne.getName())
//                  .isEqualTo(top.getName());
    }
}