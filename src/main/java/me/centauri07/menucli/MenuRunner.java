package me.centauri07.menucli;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuRunner {
    private final Scanner scanner;
    private final Deque<Menu> history = new ArrayDeque<>();

    private Menu current;

    public MenuRunner(Menu root, Scanner scanner) {
        this.current = root;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            current.run();

            int choice = scanner.nextInt();

            if (choice == 0) {
                try {
                    current = history.pop();
                } catch (NoSuchElementException e) {
                    break;
                }
                continue;
            }

            MenuOption selected = current.getOptions()[choice - 1];

            if (selected instanceof MenuAction) {
                selected.run();
            } else {
                history.push(current);
                current = (Menu) selected;
            }
        }
    }
}