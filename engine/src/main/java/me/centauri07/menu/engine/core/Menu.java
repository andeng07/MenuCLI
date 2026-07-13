package me.centauri07.menu.engine.core;

public class Menu extends Option {
    private final Option[] options;

    public Menu(Component component, Option[] options) {
        super(component);
        this.options = options;
    }

    public Option[] getOptions() {
        return options;
    }
}