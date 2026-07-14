package me.centauri07.menu.engine.core;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Option {
    private final Component component;

    public Option(@NotNull Component component) {
        Objects.requireNonNull(component);

        this.component = component;
    }

    public String getName() {
        return component.getName();
    }

    public String getDescription() {
        return component.getDescription();
    }
}