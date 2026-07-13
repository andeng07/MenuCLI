package me.centauri07.menucli.view;

import me.centauri07.menucli.core.Menu;
import me.centauri07.menucli.core.MenuOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenuView implements MenuView {
    private final Scanner scanner;

    public ConsoleMenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void renderMenu(Menu menu) {
        System.out.println("[Menu] " + menu.getName() + ": " + menu.getDescription());

        System.out.println("[0] Back");

        MenuOption[] options = menu.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + options[i].getName() + " - " + options[i].getDescription());
        }
    }

    @Override
    public MenuOption selectOption(Menu menu) {
        int systemInput;

        do {
            try {
                systemInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                systemInput = -1;
                scanner.nextLine();
            }
        } while (systemInput < 0 || systemInput > menu.getOptions().length);

        if (systemInput == 0) return null;

        return menu.getOptions()[systemInput - 1];
    }
}
