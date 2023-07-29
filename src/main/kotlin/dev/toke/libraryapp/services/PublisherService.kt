package dev.toke.libraryapp.services

import dev.toke.libraryapp.models.Publisher
import dev.toke.libraryapp.repositories.PublisherRepository
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class PublisherService(val publisherRepository: PublisherRepository) {
    fun addPublisher(publisher: Publisher) : Publisher {
        publisherRepository.save(publisher)
        return publisher
    }

    fun getPublishers() : List<Publisher> {
        return publisherRepository.findAll().toList()
    }

    fun getPublisherById( id: Long) : Publisher? {
        return publisherRepository.findByIdOrNull(id)
    }
}