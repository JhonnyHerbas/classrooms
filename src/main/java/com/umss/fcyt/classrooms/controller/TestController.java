package com.umss.fcyt.classrooms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umss.fcyt.classrooms.util.constants.ControllersConstants.Api;

@RestController
@RequestMapping(Api.API)
public class TestController {

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }
}
