package me.centauri07.menu.engine.runner;

import me.centauri07.menu.engine.core.*;
import me.centauri07.menu.engine.view.MenuView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MenuRunner<C extends Context> {
    private final C context;
    private final MenuView<C> menuView;
    private final Deque<Menu> history = new ArrayDeque<>();

    private Menu current;

    public MenuRunner(@NotNull C context, @NotNull Menu root, @NotNull MenuView<C> menuView) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(root);
        Objects.requireNonNull(menuView);

        this.context = context;
        this.current = root;
        this.menuView = menuView;
    }

    public void start() {
        while (true) {
            menuView.renderMenu(context, current);

            Option selected = menuView.selectOption(context, current);

            if (selected == null) {
                try {
                    current = history.pop();
                } catch (NoSuchElementException e) {
                    break;
                }
                continue;
            }

            if (selected instanceof Action) {
                ((Action) selected).run(context);
            } else {
                history.push(current);
                current = (Menu) selected;
            }
        }
    }
}