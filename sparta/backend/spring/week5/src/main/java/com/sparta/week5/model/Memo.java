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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String createdBy;

    public Memo(String title, String createdBy) {
        this.title = title;
        this.createdBy = createdBy;
    }

    public Memo(MemoDTO memoDTO){
        this.title = memoDTO.getTitle();
        this.createdBy = memoDTO.getCreatedBy();
    }
}
