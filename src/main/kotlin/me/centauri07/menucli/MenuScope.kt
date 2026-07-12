package me.centauri07.menucli

import me.centauri07.menucli.core.Menu
import me.centauri07.menucli.core.MenuAction
import me.centauri07.menucli.core.MenuOption

@DslMarker
internal annotation class MenuScopeMarker

@MenuScopeMarker
class MenuScope(private val name: String, private val description: String) {
    private val options = mutableListOf<MenuOption>()

    fun action(action: MenuAction) = options.add(action)

    fun action(name: String, description: String, block: () -> Unit) {
        val action = MenuAction(name, description, block)

        options.add(action)
    }

    fun submenu(submenu: Menu) = options.add(submenu)

    fun submenu(name: String, description: String, block: MenuScope.() -> Unit) {
        val scope = MenuScope(name, description)

        scope.block()

        options.add(scope.construct())
    }

    internal fun construct(): Menu {
        return Menu(name, description, options.toTypedArray())
    }
}