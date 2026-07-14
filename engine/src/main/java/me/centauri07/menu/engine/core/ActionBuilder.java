package me.centauri07.menu.engine.core;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ActionBuilder {
    private Component component;
    private Consumer<Context> action;

    public ActionBuilder setComponent(@NotNull Component component) {
        this.component = component;

        return this;
    }

    public ActionBuilder setAction(@NotNull Consumer<Context> action) {
        this.action = action;

        return this;
    }

    public Action build() {
        return new Action(component, action);
    }

}
