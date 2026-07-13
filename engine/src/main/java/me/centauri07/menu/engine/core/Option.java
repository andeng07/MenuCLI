package me.centauri07.menu.engine.core;

public class Option {
    private final Component component;

    public Option(Component component) {
        this.component = component;
    }

    public String getName() {
        return component.getName();
    }

    public String getDescription() {
        return component.getDescription();
    }
}