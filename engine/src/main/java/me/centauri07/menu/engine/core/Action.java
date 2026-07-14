package me.centauri07.menu.engine.core;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class Action extends Option {

    private final Consumer<Context> action;

    public Action(@NotNull Component component, @NotNull Consumer<Context> action) {
        super(component);

        Objects.requireNonNull(action);

        this.action = action;
    }

    public void run(@NotNull Context context) {
        action.accept(context);
    }

}
