package com.arnoldatse.authmanager.customers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class publicController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
