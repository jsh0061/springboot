// 게시글 리스트뿐만 아니라 게시글 하나에 대한 요청도 처리할 수 있게 BoardService 클래스 작성
package com.tutorial.springboard.service;

import com.tutorial.springboard.domain.Board;
import com.tutorial.springboard.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    public Page<Board> findBoardList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber());
        pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC,  "boardType", "updatedDate"));
        return boardRepository.findAll(pageable);
    }

    public Board findBoardByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }

    public void create() {
    }
//    public Board create() {
//        board.setCreatedDateNow();
//        boardRepository.save(board);
//    }

}