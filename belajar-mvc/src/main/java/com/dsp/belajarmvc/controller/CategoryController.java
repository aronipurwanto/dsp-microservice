package com.dsp.belajarmvc.controller;

import com.dsp.belajarmvc.model.request.CategoryRequest;
import com.dsp.belajarmvc.model.response.CategoryResponse;
import com.dsp.belajarmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("category/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoryRequest request){
        Optional<CategoryResponse> result = service.save(request);
        if(result.isEmpty()){
            ModelAndView view = new ModelAndView("category/add");
            view.addObject("error", "Save failed");
            return view;
        }
        return new ModelAndView("redirect:/category");
    }
}
