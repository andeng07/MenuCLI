package me.centauri07.menu.engine.core;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Menu extends Option {
    private final Option[] options;

    public Menu(@NotNull Component component, @NotNull Option[] options) {
        super(component);

        Objects.requireNonNull(options);

        this.options = options;
    }

    public Option[] getOptions() {
        return options;
    }
}