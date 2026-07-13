package me.centauri07.menu.swing;

import me.centauri07.menu.engine.core.Context;

import javax.swing.*;

public class SwingContext implements Context {
    private final JComponent component;

    public SwingContext(JComponent component) {
        this.component = component;
    }

    public JComponent getComponent() {
        return component;
    }

    public String prompt(String message) {
        return JOptionPane.showInputDialog(component, message);
    }

    public void message(String message) {
        JOptionPane.showMessageDialog(component, message);
    }
}
