package com.tutorial.springboard.repository;

import com.tutorial.springboard.domain.BoardView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardViewRepository extends JpaRepository<BoardView, Long> {

}
