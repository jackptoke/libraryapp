package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.services.AuthorService
import dev.toke.libraryapp.services.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebController(val bookService: BookService, val authorService: AuthorService) {
    @RequestMapping("/web/books")
    fun getBooks(model: Model) : String {
        model.addAttribute("books", bookService.getBooks())
        return "books"
    }

    @RequestMapping("/web/authors")
    fun getAuthors(model: Model) : String {
        model.addAttribute("authors", authorService.getAuthors())
        return "authors"
    }
}