package com.example.week7.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteResponseDto {
    private String msg;
    private boolean res;
    private boolean loggedIn;
}
