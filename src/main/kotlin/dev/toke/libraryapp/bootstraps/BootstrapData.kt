package dev.toke.libraryapp.bootstraps

import dev.toke.libraryapp.models.Author
import dev.toke.libraryapp.models.Book
import dev.toke.libraryapp.models.Publisher
import dev.toke.libraryapp.repositories.AuthorRepository
import dev.toke.libraryapp.repositories.BookRepository
import dev.toke.libraryapp.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(val authorRepo: AuthorRepository, val bookRepo: BookRepository, val publisherRepository: PublisherRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val eric = Author(id = null, firstName = "Eric", lastName = "Wald")
        val bryce = Author(id = null, firstName = "Bryce", lastName = "Hoffman")

        val penguin = Publisher(id = null, name = "Penguin Publication", website = "www.penguin.com", address = "Collin Street", city = "Melbourne", state = "VIC", postcode = "3000")
        val savedPenguin = publisherRepository.save(penguin)
        val disruption = Book(id = null, title = "The Great Disruption", isbn = "978-1-61039-507-6", description = "Disruptive forces are re-shaping our world faster than ever.  But which way are the winds of change blowing?  And what are the implications for business today?", publisher = savedPenguin )
        val redTeaming = Book(id = null, title = "RED Teaming", isbn = "9780349410418", description = "The game-changing approach to strategy and planning that will keep your business ahead of the competition", publisher = savedPenguin)

        authorRepo.save(eric)
        authorRepo.save(bryce)

        disruption.authors.add(eric)
        redTeaming.authors.add(eric)
        redTeaming.authors.add(bryce)

        bookRepo.save(disruption)
    }
}