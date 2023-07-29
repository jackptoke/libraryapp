package dev.toke.libraryapp.services

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("languageMenuService")
@Profile("EN", "default")
class EnglishMenuService : MenuService {
    override fun getMenu(): String {
        return "This is English Menu"
    }
}