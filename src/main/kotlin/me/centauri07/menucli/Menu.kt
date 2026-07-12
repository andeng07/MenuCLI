package me.centauri07.menucli

import me.centauri07.menucli.core.Menu

fun menu(name: String, description: String, block: MenuScope.() -> Unit): Menu {
    val scope = MenuScope(name, description)
    scope.block()

    return scope.construct()
}