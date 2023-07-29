package dev.toke.libraryapp.services

import dev.toke.libraryapp.models.Book
import dev.toke.libraryapp.repositories.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class BookService(val bookRepository : BookRepository) {
    fun getBooks(): List<Book> = bookRepository.findAll().toList()
    fun getBook(id: Long): Book? = bookRepository.findByIdOrNull(id)
}