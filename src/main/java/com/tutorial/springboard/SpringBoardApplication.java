package com.tutorial.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoardApplication.class, args);
        System.out.printf("hello world");
    }
}
//
//import com.tutorial.springboard.domain.Board;
//import com.tutorial.springboard.domain.User;
//import com.tutorial.springboard.domain.enums.BoardType;
//import com.tutorial.springboard.repository.BoardRepository;
//import com.tutorial.springboard.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.time.LocalDateTime;
//import java.util.stream.IntStream;
//
//@SpringBootApplication
//public class SpringBoardApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBoardApplication.class, args);
//    }
//
//    @Autowired
//
//    @Bean
//    public CommandLineRunner runner(UserRepository userRepository,
//                                    BoardRepository boardRepository) throws Exception{
//        return(args) -> {
//            User user = userRepository.save(User.builder()
//                    .name("test")
//                    .password("1234")
//                    .email("test@gmail.com")
//                    .createdDate(LocalDateTime.now())
//                    .build());
//
//            IntStream.rangeClosed(1, 200).forEach(index ->
//                    boardRepository.save(Board.builder()
//                            .title("게시글"+index)
//                            .subTitle("순서"+index)
//                            .content("콘텐츠")
//                            .boardType(BoardType.free)
//                            .createdDate(LocalDateTime.now())
//                            .updatedDate(LocalDateTime.now())
//                            .user(user).build())
//            );
//        };
//    }
//}
