package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {// Type , id

    // select m from Member m where m.name = ?   메서드 이름 findByooo보고 jpql을 만든다.
    List<Member> findByName(String name);
}
