package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.models.Book
import dev.toke.libraryapp.repositories.BookRepository
import dev.toke.libraryapp.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController(val bookService: BookService) {

    @GetMapping
    fun getBooks(): List<Book> = bookService.getBooks()

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Book? = bookService.getBook(id)
}