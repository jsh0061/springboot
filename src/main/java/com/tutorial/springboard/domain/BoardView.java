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
@Builder
public class BoardView {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idx;

    @Column
    private LocalDateTime boardDate;
    private BoardView boardview;

    @Builder
    public BoardView(LocalDateTime boardDate) {
        this.boardDate = boardDate;
    }

    public void setCreatedDateNow(BoardView boardView) {
        this.boardDate = LocalDateTime.now();
    }
}
