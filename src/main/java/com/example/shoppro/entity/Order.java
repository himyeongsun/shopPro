package com.example.shoppro.entity;

import com.example.shoppro.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    
    // 주문상품앤티티와 일대다 매핑
    // 외래키(order_id)가 order_item 테이블에 있으면
    // 연관관계의 주인은 orderitem앤티티 
    // order는 주인이 아니므로 mappedby 속성으로 주인 설정
    // : order를 mappedby에 적어준 이유
    //  orderItem에 있는 order에 의해 관리된다.
    // orphanRemoval = true

    // Entity를 가져왔을 때 order, orderItemList 값이 있다면
    // order, orderItemList.remove(0);
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;    // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;




}
