package dev.toke.libraryapp.services

import dev.toke.libraryapp.models.Author
import dev.toke.libraryapp.repositories.AuthorRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

//@Qualifier("EN")

@Service
class AuthorService(val authorRepository: AuthorRepository) {
    fun getAuthors(): List<Author> = authorRepository.findAll().toList()
    fun getAuthorById(id: Long): Author? = authorRepository.findByIdOrNull(id)
    fun getLanguage(): String = "This is English language service"
}