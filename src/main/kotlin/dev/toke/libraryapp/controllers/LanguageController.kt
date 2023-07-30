package dev.toke.libraryapp.controllers

import dev.toke.libraryapp.services.MenuService
import mu.KLogging
import org.springframework.stereotype.Controller

@Controller
class LanguageController(val menuService: MenuService) {
    companion object : KLogging()
    fun getMenu(): String {
        logger.info("Language Controller - getMenu")
        return menuService.getMenu()
    }
}