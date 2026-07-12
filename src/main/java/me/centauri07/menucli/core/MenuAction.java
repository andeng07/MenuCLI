package me.centauri07.menucli.core;

public class MenuAction extends MenuOption {

    private final Runnable action;

    public MenuAction(String name, String description, Runnable action) {
        super(name, description);
        this.action = action;
    }

    public void run() {
        action.run();
    }

}
