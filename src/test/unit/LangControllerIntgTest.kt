import dev.toke.libraryapp.LibraryappApplication
import com.ninjasquad.springmockk.MockkBean
import dev.toke.libraryapp.controllers.LanguageController
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.reactive.server.WebTestClient

// Unit test

@ActiveProfiles("test", "EN")
@WebMvcTest(controllers = [LanguageController::class])
@ContextConfiguration(classes = [LibraryappApplication::class])
@AutoConfigureWebTestClient
class LangControllerIntgTest() {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var languageController: LanguageController

    @Test
    fun retrieveMenu() {

        // Mocking the output of the controller
        every { languageController.getMenu() } returns "This is English Menu"

        val menu = languageController.getMenu()
        Assertions.assertEquals("This is English Menu", menu)
    }
}