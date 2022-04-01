package com.jun.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")    // 머스테치에 url 매핑
    public String index() {
        return "index";
    }
}
