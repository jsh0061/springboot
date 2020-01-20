package com.tutorial.springboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
//@Builder
public class BoardView {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idx;

    @Column
    private LocalDateTime boardDate;

    @ManyToOne
    private Board board;

    @OneToOne(fetch=FetchType.LAZY)
    private User user;

    @Builder
    public BoardView(Board board, User user) {
        this.board = board;
        this.user = user;
        this.boardDate = LocalDateTime.now();
    }

}
