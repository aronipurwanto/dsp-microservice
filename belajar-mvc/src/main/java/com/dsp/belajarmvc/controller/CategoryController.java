package com.dsp.belajarmvc.controller;

import com.dsp.belajarmvc.model.response.CategoryResponse;
import com.dsp.belajarmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView get(){
        List<CategoryResponse> data = service.getAll();
        ModelAndView view = new ModelAndView("category/index");
        // send data to view
        view.addObject("dataList", data);
        return view;
    }
}
