package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @RequestMapping("/index") 
    public String greeting(Model model) {
        //model.addAttribute("name", name);
        //model.addAttribute("age", age);
        return "index";
    }
}