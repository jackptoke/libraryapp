package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.db.DbConnectionService
import dev.toke.libraryapp.models.Author
import dev.toke.libraryapp.services.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/authors")
@ResponseBody
class AuthorController(private var authorService: AuthorService, private val dbConnectionService: DbConnectionService) {
//    constructor(@Qualifier("EN") authorService: AuthorService) {
//        this.authorService = authorService
//    }
    @GetMapping
    fun getAuthors() : List<Author> = authorService.getAuthors()

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long) : Author? = authorService.getAuthorById(id)

    @GetMapping("/conx")
    fun getSomeText() : String {
        return dbConnectionService.getConnectionString()
    }

}