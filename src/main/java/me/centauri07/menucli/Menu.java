package me.centauri07.menucli;

public class Menu extends MenuOption {
    private final MenuOption[] options;

    public Menu(String name, String description, MenuOption[] options) {
        super(name, description);
        this.options = options;
    }

    @Override
    public void run() {
        System.out.println("[Menu] " + name + ": " + description);

        System.out.println("[0] Back");
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i].name + " - " + options[i].description);
        }
    }

    public MenuOption[] getOptions() {
        return options;
    }
}