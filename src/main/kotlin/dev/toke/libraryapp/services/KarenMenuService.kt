package dev.toke.libraryapp.services

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("languageMenuService")
@Profile("KSW")
class KarenMenuService : MenuService {
    override fun getMenu(): String {
        return "This is Karen menu"
    }
}