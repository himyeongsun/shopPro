package com.example.shoppro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;        //현재 저장된 주문아이템pk



//    private ItemDTO itemDTO;      // 다 가져올 필요는 없으니

    private String itemNm;          //그중에 상품명만

    private int orderPrice;     //주문가격

    private int count;         //수량
    
    private String imgUrl;      //대표이미지만






}
