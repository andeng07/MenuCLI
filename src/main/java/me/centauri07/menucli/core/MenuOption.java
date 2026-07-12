package me.centauri07.menucli.core;

public abstract class MenuOption {
    protected final String name;
    protected final String description;

    public MenuOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
