package com.example.bookstore.web;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	public String save(Book book){
        repository.save(book);
        //return "redirect:studentlist";
        return "test";
    }

	@RequestMapping(value= {"/", "/booklist"}) 
	public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}










