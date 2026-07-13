package me.centauri07.menu.engine.core;

import java.util.function.Consumer;

public class Action extends Option {

    private final Consumer<Context> action;

    public Action(Component component, Consumer<Context> action) {
        super(component);
        this.action = action;
    }

    public void run(Context context) {
        action.accept(context);
    }

}
