package me.centauri07.menucli.core;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {
    private String name;
    private String description;
    private final List<MenuOption> options = new ArrayList<>();

    public MenuBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public MenuBuilder setDescription(String description) {
        this.description = description;

        return this;
    }

    public MenuBuilder addOption(MenuOption option) {
        this.options.add(option);

        return this;
    }

    public Menu build() {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            throw new IllegalStateException();
        }

        return new Menu(name, description, options.toArray(new MenuOption[0]));
    }
}
