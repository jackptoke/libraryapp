import com.ninjasquad.springmockk.MockkBean
import dev.toke.libraryapp.LibraryappApplication
import dev.toke.libraryapp.controllers.AuthorController
import dev.toke.libraryapp.db.DbConnectionService
import dev.toke.libraryapp.models.Author
import dev.toke.libraryapp.services.AuthorService
import dev.toke.libraryapp.utils.authorDto
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [AuthorController::class])
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [LibraryappApplication::class])
@AutoConfigureWebTestClient
class AuthorControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var dbConxService: DbConnectionService

    @MockkBean
    lateinit var authorServiceMockk: AuthorService

    @Test
    @WithMockUser
    fun getAuthors() {

        every { authorServiceMockk.getAuthors() }.returnsMany(
            listOf(authorDto(firstName = "Jack", lastName = "Toke"), authorDto(firstName = "Josiah", lastName = "Toke"))
        )

        val resultDTOs = webTestClient.get()
            .uri("/api/authors")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(Author::class.java)
            .returnResult().responseBody

        Assertions.assertEquals(2, resultDTOs?.size)
    }


}