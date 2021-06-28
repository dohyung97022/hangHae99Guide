package com.sparta.week5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/post_memo", method = RequestMethod.GET)
    public String postMemo() {
        return "post_memo.html";
    }

    @RequestMapping(value = "/inspect_memo/{id}", method = RequestMethod.GET)
    public String inspectMemo() {
        return "inspect_memo.html";
    }
}
