//게시글
package com.tutorial.springboard.domain;

import com.tutorial.springboard.domain.enums.BoardType;
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
public class Board {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @OneToOne(fetch=FetchType.LAZY)
    private User user;


//    삭제, 수정을 위해 소스 추가
@Builder
public Board(String title, String subTitle, String content, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate, User user) {
    this.title = title;
    this.subTitle = subTitle;
    this.content = content;
    this.boardType = boardType;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.user = user;
}

    public void setCreatedDateNow() {
        this.createdDate = LocalDateTime.now();
    }

    public void update(Board board) {
        this.title = board.getTitle();
        this.subTitle = board.getSubTitle();
        this.content = board.getContent();
        this.boardType = board.getBoardType();
        this.updatedDate = LocalDateTime.now();
    }

}

//import com.tutorial.springboard.domain.enums.BoardType;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table
//public class Board implements Serializable {
//
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idx;
//
//    @Column
//    private String title;
//
//    @Column
//    private String subTitle;
//
//    @Column
//    private String content;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private BoardType boardType;
//
//    @Column
//    private LocalDateTime createdDate;
//
//    @Column
//    private LocalDateTime updatedDate;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    private User user;
//
//    @Builder
//    public Board(String title, String subTitle, String content, BoardType boardType,
//                 LocalDateTime createdDate, LocalDateTime updatedDate, User user){
//        this.title = title;
//        this.subTitle = subTitle;
//        this.content = content;
//        this.boardType = boardType;
//        this.createdDate = createdDate;
//        this.updatedDate = updatedDate;
//        this.user = user;
//    }
//
//}