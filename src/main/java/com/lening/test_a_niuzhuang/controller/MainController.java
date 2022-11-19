package com.lening.test_a_niuzhuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "list";
    }
    @RequestMapping("/toInsert")
    public String toInsert(){
        return "insert";
    }

}
