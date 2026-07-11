package me.centauri07.menucli

fun menu(name: String, description: String, block: MenuScope.() -> Unit): Menu {
    val scope = MenuScope(name, description)
    scope.block()

    return scope.construct()
}