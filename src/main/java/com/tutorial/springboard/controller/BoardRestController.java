package com.tutorial.springboard.controller;



import com.tutorial.springboard.domain.Board;
import com.tutorial.springboard.repository.BoardRepository;



import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/api/boards")

public class BoardRestController {



    private final BoardRepository boardRepository;



    public BoardRestController(BoardRepository boardRepository) {

        this.boardRepository = boardRepository;

    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)




    @PostMapping

    public ResponseEntity<?> postBoard(@RequestBody Board board) {

        board.setCreatedDateNow();

        boardRepository.save(board);

        return new ResponseEntity<>("{}", HttpStatus.OK);

    }



    @PutMapping("/{idx}")

    public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx,

                                      @RequestBody Board board) {

        Board persistBoard = boardRepository.getOne(idx);

        persistBoard.update(board);

        boardRepository.save(persistBoard);

        return new ResponseEntity<>("{}", HttpStatus.OK);

    }



    @DeleteMapping("/{idx}")

    public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {

        boardRepository.deleteById(idx);

        return new ResponseEntity<>("{}", HttpStatus.OK);

    }



}