package dev.toke.libraryapp.repositories

import dev.toke.libraryapp.models.Publisher
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository : CrudRepository<Publisher, Long>{
}