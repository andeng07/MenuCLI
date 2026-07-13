package me.centauri07.menu.engine.view;

import me.centauri07.menu.engine.core.Context;
import me.centauri07.menu.engine.core.Menu;
import me.centauri07.menu.engine.core.Option;

public interface MenuView<C extends Context> {
    void renderMenu(C context, Menu menu);
    Option selectOption(C context, Menu menu);
}