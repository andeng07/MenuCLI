package me.centauri07.menu.engine.core;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {
    private Component component;
    private final List<Option> options = new ArrayList<>();

    public MenuBuilder setComponent(Component component) {
        this.component = component;

        return this;
    }

    public MenuBuilder addOption(Option option) {
        this.options.add(option);

        return this;
    }

    public Menu build() {
        if (component == null) {
            throw new IllegalStateException();
        }

        return new Menu(component, options.toArray(new Option[0]));
    }
}