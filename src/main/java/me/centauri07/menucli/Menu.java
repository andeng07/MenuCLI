package me.centauri07.menucli;

public class Menu extends MenuOption {
    private final MenuOption[] options;

    public Menu(String name, String description, MenuOption[] options) {
        super(name, description);
        this.options = options;
    }

    public MenuOption[] getOptions() {
        return options;
    }
}