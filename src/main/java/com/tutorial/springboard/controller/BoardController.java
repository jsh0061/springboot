package com.tutorial.springboard.controller;

import com.tutorial.springboard.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping({"", "/"})
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx,
                        Model model){
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "board/list";
    }



}
