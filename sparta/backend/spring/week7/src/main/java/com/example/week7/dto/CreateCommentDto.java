package com.example.week7.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCommentDto {
    private Long threadId;
    private String content;
}
