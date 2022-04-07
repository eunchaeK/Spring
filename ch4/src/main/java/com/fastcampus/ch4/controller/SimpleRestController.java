package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleRestController {
//    @GetMapping("/ajax")
//    public String ajax() {
//        return "ajax";
//    }

//    @ResponseBody
    @PostMapping("/send")
    public Person test(@RequestBody Person p) {    // jackson-databind가 String->Java 객체로 변환
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }

//    @ResponseBody
    @PostMapping("/send")
    public Person test2(@RequestBody Person p) {    // jackson-databind가 String->Java 객체로 변환
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}