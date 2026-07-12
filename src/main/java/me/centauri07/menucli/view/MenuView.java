package me.centauri07.menucli.view;

import me.centauri07.menucli.core.Menu;
import me.centauri07.menucli.core.MenuOption;

public interface MenuView {
    void renderMenu(Menu menu);
    MenuOption selectOption(Menu menu);
}
