package com.tutorial.springboard.repository;

import com.tutorial.springboard.domain.Board;

import com.tutorial.springboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Board 정보를 영속화하기 위한 DB 인터페이스인 BoardRepository 인터페이스
//@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findByUser(User user);
}
