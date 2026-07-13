package me.centauri07.menu.engine

import me.centauri07.menu.engine.core.Action
import me.centauri07.menu.engine.core.Component
import me.centauri07.menu.engine.core.Context
import me.centauri07.menu.engine.core.Menu
import me.centauri07.menu.engine.core.Option

@DslMarker
internal annotation class MenuScopeMarker

@MenuScopeMarker
class MenuScope(private val component: Component) {
    private val options = mutableListOf<Option>()

    fun action(action: Action) = options.add(action)

    fun action(component: Component, block: (Context) -> Unit) {
        val action = Action(component, block)

        options.add(action)
    }

    fun submenu(submenu: Menu) = options.add(submenu)

    fun submenu(component: Component, block: MenuScope.() -> Unit) {
        val scope = MenuScope(component)

        scope.block()

        options.add(scope.construct())
    }

    internal fun construct(): Menu {
        return Menu(component, options.toTypedArray())
    }
}