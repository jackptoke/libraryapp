package dev.toke.libraryapp.utils

import dev.toke.libraryapp.models.Author

fun authorDto(firstName: String, lastName: String) = Author(id = null, firstName = firstName, lastName = lastName)