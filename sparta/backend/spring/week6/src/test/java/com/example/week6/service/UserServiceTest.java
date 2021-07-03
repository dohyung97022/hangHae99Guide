package com.example.week6.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void registerUser() {
        assertEquals(1,10,"test");
        assertAll(
                ()->assertEquals(1,2),
                ()->assertEquals(3,3),
                ()->assertEquals(4,4)
        );
    }

    @Test
    void kakaoLogin() {
    }
}