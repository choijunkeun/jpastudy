package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 하나의 회원이 여러개의 상품을 주문하기 때문에 일대다 관계
    // mappedBy : 나는 매핑하는애가 아니고 매핑된 거울일 뿐이다라는 뜻(읽기전용)
    @OneToMany(mappedBy = "member") // Order에 있는  member필드에 의해 매핑된거라는 뜻.
    private List<Order> orders = new ArrayList<>();



}
