package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {
    @EntityGraph(attributePaths = {"boards"})  // 여러개의 sql문을 발생하지 않고 하나의 join문으로 sql문을 발생시켜 성능상 이점이 생김.
    List<User> findAll();

    User findByUsername(String username);

}
