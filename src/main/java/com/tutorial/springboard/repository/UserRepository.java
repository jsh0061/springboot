package com.tutorial.springboard.repository;

import com.tutorial.springboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//User를 영속화하기 위한 DB인터페이스인 UserRepository인터페이스
//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
