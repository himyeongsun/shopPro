package com.example.shoppro.repository;

import com.example.shoppro.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 로그인한 유저 정보 email을 통해서 각종 검색을 위한 기능
    // 등록시에도 사용
    // 로그인한 사람의 아이템에서도 사용
    // 등록한 글 수정 시 : 로그인한 사람의 정보를 받아와 글 등록한 사람과 비교 시에도 사용
    // 글, 댓글, 리뷰, 아이템을 삭제할때도 같아야 삭제 하는데 ,
    // 같은지 알려면 먼저 로그인한 사람의 정보를 받아와야 하기 때문에 필요
    Member findByEmail(String email);

}
