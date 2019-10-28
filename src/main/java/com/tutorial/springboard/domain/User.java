// 유저정보
package com.tutorial.springboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class User implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idx;

    @Column
    public String name;

    @Column
    public String password;

    @Column
    public String email;

    @Column
    public LocalDateTime createdDate;

    @Column
    public LocalDateTime updatedDate;


}

//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Table
//public class User implements Serializable {
//
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idx;
//
//    @Column
//    private String name;
//
//    @Column
//    private String password;
//
//    @Column
//    private String email;
//
//    @Column
//    private String principal;
//
//
//    @Enumerated(EnumType.STRING)
//    @Column
//    private LocalDateTime createdDate;
//
//    @Column
//    private LocalDateTime updatedDate;
//
//    @Builder
//    public User(String name, String password, String email, String principal,
//                LocalDateTime createdDate, LocalDateTime updatedDate){
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.principal = principal;
//        this.createdDate = createdDate;
//        this.updatedDate = updatedDate;
//    }
//}