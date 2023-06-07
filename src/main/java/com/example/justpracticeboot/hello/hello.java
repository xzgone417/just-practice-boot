package com.example.justpracticeboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class hello {
    @ResponseBody
    @RequestMapping("/api/hello")
    public String hello() {
        return "Hello 徐正罡!";
    }
}