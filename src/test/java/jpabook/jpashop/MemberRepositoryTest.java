package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional  // 트랜잭션어노테이션이 테스트에 있으면 테스트 끝난 후 롤백해버림.
    @Rollback(false)        // 트랜잭션 롤백을 false로 바꿈
    public void testMember() throws Exception {
        // given
        Member member = new Member();
        member.setUserName("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member : " + (findMember == member));

    }
}