package com.tutorial.springboard.controller;

import com.tutorial.springboard.service.BoardService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//BoardController는 /board URL을 매핑하며 /board/list 을 관리합니다.
///board/list 는 게시글의 데이터를 FETCH하는 데 쓰이며 서비스 계층인 BoardService에서 해당 페이징 처리를 하게 됩니다.
//Model은 View 층에서 JSP나 Thymeleaf와 같은 템플릿 엔진이 동적으로 HTML 페이지를 만드는 데 필요한 데이터를 제공해줍니다. 위와 같은 경우 boardList 속성 혹은 board 속성에 대한 데이터를 model에 추가하는 것을 볼 수 있습니다. 이 데이터는 뒤에서 보실 Thymeleaf 코드에서 게시글을 만들 때 쓰여집니다.

//@Controller
////@RequestMapping("/board")
////public class BoardController {
////    @Autowired
////    BoardService boardService;
////
////    @GetMapping({"", "/"})
////    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
////    model.addAttribute("board",boardService.findBoardByIdx(idx));
////    return "/board/form";
////    }
////
////
////    @GetMapping("/list")
////    public String list(@PageableDefault Pageable pageable, Model model) {
////        Page<Board> boardList = boardService.findBoardList(pageable);
////        boardList.stream().forEach(e -> e.getContent());
////        model.addAttribute("boardList",boardList);
////
////        return "/board/list";
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
