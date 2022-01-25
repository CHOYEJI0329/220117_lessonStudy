package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.User;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findByUsernameCustom(String username) {
//        quserdsl로 예제문을 작성 하였는데 왜인지 강의와는 다르게 나한테는 QUser이 import가 안됨.
//        꼭 quserdsl로 안해도 여러 방법이 있음. 방법이 너무 많아서 고르기 힘들정도.
       /* QUser quser = QUser.user;
        JPAQuery<?> query = new JPAQuery<Void>(em);
        List<User> users = query.select(quser)
                .from(quser)
                .where(quser.username.contains(username))
                .fetch();
        return users;*/
        return null;   // 임시
    }
}
