package me.centauri07.menucli.runner;

import me.centauri07.menucli.view.MenuView;
import me.centauri07.menucli.core.Menu;
import me.centauri07.menucli.core.MenuAction;
import me.centauri07.menucli.core.MenuOption;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MenuRunner {
    private final MenuView menuView;
    private final Deque<Menu> history = new ArrayDeque<>();

    private Menu current;

    public MenuRunner(Menu root, MenuView menuView) {
        this.current = root;
        this.menuView = menuView;
    }

    public void start() {
        while (true) {
            menuView.renderMenu(current);

            MenuOption selected = menuView.selectOption(current);

            if (selected == null) {
                try {
                    current = history.pop();
                } catch (NoSuchElementException e) {
                    break;
                }
                continue;
            }

            if (selected instanceof MenuAction) {
                ((MenuAction) selected).run();
            } else {
                history.push(current);
                current = (Menu) selected;
            }
        }
    }
}