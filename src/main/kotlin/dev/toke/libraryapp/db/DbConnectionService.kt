package dev.toke.libraryapp.services

interface DbConnectionService {
    fun getConnectionString() : String
}