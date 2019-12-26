package de.phschaefer.spring5webapp.controllers;

import de.phschaefer.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getAllBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());

        return "books";
    }
}
