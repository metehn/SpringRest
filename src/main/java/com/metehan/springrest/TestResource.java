package com.metehan.springrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {


    @GetMapping("/test/message")
    public String getMessage(){

        return "{ \"message\": \"Spring Rest Test\" }";
    }
}
