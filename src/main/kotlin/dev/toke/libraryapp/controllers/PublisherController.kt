package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.services.PublisherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/publishers")
class PublisherController(val publisherService: PublisherService) {
    @GetMapping
    fun getPublishers() = publisherService.getPublishers()

    @GetMapping("/{id}")
    fun getPublisher(@PathVariable id: Long) = publisherService.getPublisherById(id)
}