package com.mycompany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public static String INIT_MESSAGE = "Init was done successfully. Test with Pavlo";

    @GetMapping("/init")
    public String init() {
        return INIT_MESSAGE;
    }
}
