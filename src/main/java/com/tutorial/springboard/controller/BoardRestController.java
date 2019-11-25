package com.tutorial.springboard.controller;


import com.tutorial.springboard.domain.Board;
import com.tutorial.springboard.domain.BoardView;
import com.tutorial.springboard.repository.BoardRepository;
import com.tutorial.springboard.repository.BoardViewRepository;
import com.tutorial.springboard.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/boards")
public class BoardRestController {
    private final BoardRepository boardRepository;
    private final BoardViewRepository boardViewRepository;
    private final BoardView boardView;
    private final BoardService boardService;
    public BoardRestController(BoardRepository boardRepository, BoardViewRepository boardViewRepository, BoardView boardView, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardViewRepository = boardViewRepository;
        this.boardView = boardView;
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody Board board) {
        boardService.create();
        boardView.setCreatedDateNow();
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody Board board, @RequestBody BoardView boardView) {
        Board persistBoard = boardRepository.getOne(idx);
        BoardView persistBoardView = boardViewRepository.getOne(idx);
        persistBoard.update(board);
        persistBoardView.update(boardView);
        boardRepository.save(persistBoard);
        boardViewRepository.save(persistBoardView);
//        BoardView persistBoardView = boardViewRepository.getOne(idx);
//        persistBoardView.setCreatedDateNow(boardView);
//        boardViewRepository.save(persistBoardView);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {
        boardRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }



//    @GetMapping
//    public List<Board> getAll() {
//        Pageable pageable;
//        return boardService.findBoardList(pageable);
//    }

}