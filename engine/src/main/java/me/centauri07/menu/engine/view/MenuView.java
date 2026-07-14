package me.centauri07.menu.engine.view;

import me.centauri07.menu.engine.core.Context;
import me.centauri07.menu.engine.core.Menu;
import me.centauri07.menu.engine.core.Option;
import org.jetbrains.annotations.NotNull;

public interface MenuView<C extends Context> {
    void renderMenu(@NotNull C context, @NotNull Menu menu);
    Option selectOption(@NotNull C context, @NotNull Menu menu);
}