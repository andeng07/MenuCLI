package me.centauri07.menu.cli;

import me.centauri07.menu.engine.core.Menu;
import me.centauri07.menu.engine.core.Option;
import me.centauri07.menu.engine.view.MenuView;

import java.util.InputMismatchException;

public class ConsoleView implements MenuView<ConsoleContext> {
    @Override
    public void renderMenu(ConsoleContext context, Menu menu) {
        System.out.println("[Menu] " + menu.getName() + ": " + menu.getDescription());

        System.out.println("[0] Back");

        Option[] options = menu.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i].getName() + " - " + options[i].getDescription());
        }
    }

    @Override
    public Option selectOption(ConsoleContext context, Menu menu) {
        int systemInput;

        do {
            try {
                systemInput = context.getScanner().nextInt();
            } catch (InputMismatchException e) {
                systemInput = -1;
                context.getScanner().nextLine();
            }
        } while (systemInput < 0 || systemInput > menu.getOptions().length);

        if (systemInput == 0) return null;

        return menu.getOptions()[systemInput - 1];
    }
}