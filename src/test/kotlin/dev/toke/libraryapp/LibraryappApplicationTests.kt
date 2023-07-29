package dev.toke.libraryapp

import dev.toke.libraryapp.controllers.AuthorController
import dev.toke.libraryapp.controllers.LanguageController
import dev.toke.libraryapp.db.DbConnectionService
import dev.toke.libraryapp.models.Author
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
//@ActiveProfiles("EN")
class LibraryappApplicationTests(@Autowired var languageController: LanguageController, @Autowired val dbConxService: DbConnectionService) {


    @Test
    fun textAuthorController() {
        println(languageController.getMenu())
    }

    @Test
    fun getDbConnectionStringTest() {
        println(dbConxService.getConnectionString())
    }
}
