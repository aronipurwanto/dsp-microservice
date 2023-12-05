package com.dsp.belajarmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    public void helloWorld(HttpServletResponse response)throws IOException{
        response.getWriter().println("Hello World");
    }
}
