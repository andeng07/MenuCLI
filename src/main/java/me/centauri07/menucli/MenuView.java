package me.centauri07.menucli;

public interface MenuView {
    void renderMenu(Menu menu);
    MenuOption selectOption(Menu menu);
}
