package me.centauri07.menu.swing;

import me.centauri07.menu.engine.core.Context;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Objects;

public class SwingContext implements Context {
    private final JComponent component;

    public SwingContext(@NotNull JComponent component) {
        Objects.requireNonNull(component);

        this.component = component;
    }

    public JComponent getComponent() {
        return component;
    }

    public String prompt(@NotNull String message) {
        return JOptionPane.showInputDialog(component, message);
    }

    public void message(@NotNull String message) {
        JOptionPane.showMessageDialog(component, message);
    }
}
