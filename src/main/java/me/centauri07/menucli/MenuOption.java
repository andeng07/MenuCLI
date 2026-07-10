package me.centauri07.menucli;

public abstract class MenuOption {
    protected final String name;
    protected final String description;

    public MenuOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    abstract void run();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
