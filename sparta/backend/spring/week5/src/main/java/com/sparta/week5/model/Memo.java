package com.sparta.week5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String content;

    public Memo(String title, String createdBy, String content) {
        this.title = title;
        this.createdBy = createdBy;
        this.content = content;
    }

    public Memo(MemoDTO memoDTO){
        this.title = memoDTO.getTitle();
        this.createdBy = memoDTO.getCreatedBy();
        this.content = memoDTO.getContent();
    }
}
