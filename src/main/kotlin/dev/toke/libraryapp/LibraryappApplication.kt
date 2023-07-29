package dev.toke.libraryapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryappApplication

fun main(args: Array<String>) {
//    var application = SpringApplication(LibraryappApplication::class.java)
//    application.setAdditionalProfiles("BUR")
//    application.run(*args)
    runApplication<LibraryappApplication>(*args)
}
