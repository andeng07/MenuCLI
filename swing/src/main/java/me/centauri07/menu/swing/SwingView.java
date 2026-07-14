package me.centauri07.menu.swing;

import me.centauri07.menu.engine.core.Menu;
import me.centauri07.menu.engine.core.Option;
import me.centauri07.menu.engine.view.MenuView;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SwingView implements MenuView<SwingContext> {
    private final BlockingQueue<Integer> triggers = new LinkedBlockingQueue<>();

    @Override
    public void renderMenu(@NotNull SwingContext context, @NotNull Menu menu) {
        context.getComponent().removeAll();

        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> triggers.add(0));

        context.getComponent().add(backButton);

        for (int i = 0; i < menu.getOptions().length; i++) {
            Option option = menu.getOptions()[i];

            JButton optionButton = new JButton(option.getName());

            int index = i + 1;
            optionButton.addActionListener(e -> triggers.add(index));

            context.getComponent().add(optionButton);
        }

        context.getComponent().revalidate();
        context.getComponent().repaint();
    }

    @Override
    public Option selectOption(@NotNull SwingContext context, @NotNull Menu menu) {
        int value;

        try {
            value = triggers.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (value == 0) return null;

        return menu.getOptions()[value - 1];
    }

}
