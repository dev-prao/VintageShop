package com.example.jpabook.jpashop.service;

import com.example.jpabook.jpashop.domain.Address;
import com.example.jpabook.jpashop.domain.Member;
import com.example.jpabook.jpashop.domain.Order;
import com.example.jpabook.jpashop.domain.OrderStatus;
import com.example.jpabook.jpashop.domain.exception.NotEnoughStockException;
import com.example.jpabook.jpashop.domain.item.Item;
import com.example.jpabook.jpashop.domain.item.Top;
import com.example.jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = createMember();
        Item item = createTop("무지 긴팔티", "무신사", 10000, 20, "men", "cotton");
        int orderCount = 2;

        //when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "상품 주문시 상태는 ORDER");
        assertEquals(1, getOrder.getOrderItems()
                                .size(), "주문한 상품 종류 수가 정확해야 한다.");
        assertEquals(10000 * 2, getOrder.getTotalPrice(), "주문 가격은 가격 * 수량이다.");
        assertEquals(18, item.getStockQuantity(), "주문 수량만큼 재고가 줄어야 한다.");
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //Given
        Member member = createMember();
        Item item = createTop("무지 긴팔티", "무신사", 10000, 20, "men", "cotton");
        int orderCount = 2; //재고보다 많은 수량 //When
        orderService.order(member.getId(), item.getId(), orderCount);
        //Then
        assertThrows(NotEnoughStockException.class, () -> {orderService.order(member.getId(), item.getId(), orderCount);},
                     "재고수량이 부족 하면 예외가 발생 한다 ");
    }

    @Test
    public void 주문취소 () throws Exception {
        //given
        Member member = createMember();
        Item item = createTop("무지 긴팔티", "무신사", 10000, 20, "men", "cotton");
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문 취소시 상태는 CANCLE 이다.");
        assertEquals(20, item.getStockQuantity(), "주문이 취소된 상품은 그만큼 재고가 증가해야 한다.");
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("창호");
        member.setAddress(new Address("부산", "전포", "123245"));
        em.persist(member);
        return member;
    }

    private Top createTop(String name, String brand, int price, int stockQuantity, String gender, String material) {
        Top top = new Top();
        top.setName(name);
        top.setBrand(brand);
        top.setPrice(price);
        top.setStockQuantity(stockQuantity);
        top.setGender(gender);
        top.setMaterial(material);
        em.persist(top);
        return top;
    }
}