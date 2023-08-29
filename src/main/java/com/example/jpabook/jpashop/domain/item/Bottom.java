package com.example.jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("bot")
public class Bottom extends Item {
    private int waistSize; //허리
    private int rise; //밑위
    private int length; //기장
}
