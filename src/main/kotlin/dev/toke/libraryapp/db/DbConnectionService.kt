package dev.toke.libraryapp.db

interface DbConnectionService {
    fun getConnectionString() : String
}