package ua.wwind.spring5kotlinwebapp.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ua.wwind.spring5kotlinwebapp.repositories.BookRepository

@Controller
class BookController {

    @Autowired
    lateinit var bookRepository: BookRepository

    @GetMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookRepository.findAll())
        return "books/list"
    }
}