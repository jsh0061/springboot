package com.tutorial.springboard.repository;

import com.tutorial.springboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


//User를 영속화하기 위한 DB인터페이스인 UserRepository인터페이스
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
