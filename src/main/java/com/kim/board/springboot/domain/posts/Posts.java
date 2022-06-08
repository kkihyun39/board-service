package com.kim.board.springboot.domain.posts;

import com.kim.board.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 추가
@Entity //실제 DB와 매칭될 클래스=Entity 클래스
        //DB 데이터를 작업할 경우 Entity 클래스의 수정을 통해 작업
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) //테이블 칼럼(옵션 설정할때)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder //setter없이 빌더 클래스를 이용하여 DB에 삽입 가능
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title=title;
        this.content=content;
    }
}
