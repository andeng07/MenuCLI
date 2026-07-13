package me.centauri07.menu.engine.core;

public class Component {
    private final String name;
    private final String description;

    public Component(String name, String description) {
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
