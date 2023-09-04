package com.example.jpabook.jpashop.service;

import com.example.jpabook.jpashop.domain.item.Clothes;
import com.example.jpabook.jpashop.domain.item.Item;
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


//    @Test
//    public void 상품_업데이트() throws Exception { //수정필요
//        //given
//        Item clothes = new Clothes();
//        clothes.setName("무신사");
//        itemService.saveItem(clothes);
//
//        //when
//        Item updateClothes = itemService.updateItem(clothes.getId(),"하이버","도프제이슨",10000,100);
//        Item findOne = itemService.findOne(clothes.getId());
//
//        //then
//        Assertions.assertThat(findOne.getName()).isEqualTo(updateClothes.getName());
//    }
}