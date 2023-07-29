package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.services.MenuService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Controller

@Controller
class LanguageController(val menuService: MenuService) {
    fun getMenu(): String {
        return menuService.getMenu()
    }
}