package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne  // Order의 입장에선 Member가 다대일관계 N:1 (Order가 N, Member가 1)
    @JoinColumn(name = "member_id")
    private Member member;


}
