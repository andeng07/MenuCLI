package me.centauri07.menu.engine.core;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Component {
    private final String name;
    private final String description;

    public Component(@NotNull String name, @NotNull String description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

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
