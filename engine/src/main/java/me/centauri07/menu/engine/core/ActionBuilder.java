package me.centauri07.menu.engine.core;

import java.util.function.Consumer;

public class ActionBuilder {

    private Component component;
    private Consumer<Context> action;

    public ActionBuilder setComponent(Component component) {
        this.component = component;

        return this;
    }

    public ActionBuilder setAction(Consumer<Context> action) {
        this.action = action;

        return this;
    }

    public Action build() {
        return new Action(component, action);
    }

}
