package com.dsp.belajarmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String name = request.getParameter("name");
        if(Objects.isNull(name) || name.isEmpty()){
            name = "Guest";
        }
        response.getWriter().println("Hello World, hi "+ name +" ..!");
    }
}
