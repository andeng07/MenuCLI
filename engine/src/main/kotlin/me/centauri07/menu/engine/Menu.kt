package me.centauri07.menu.engine

import me.centauri07.menu.engine.core.Component
import me.centauri07.menu.engine.core.Menu

fun menu(component: Component, block: MenuScope.() -> Unit): Menu {
    val scope = MenuScope(component)
    scope.block()

    return scope.construct()
}