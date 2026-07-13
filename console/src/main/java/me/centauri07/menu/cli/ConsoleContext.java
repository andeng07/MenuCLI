package me.centauri07.menu.cli;

import me.centauri07.menu.engine.core.Context;

import java.util.Scanner;

public class ConsoleContext implements Context {
    private Scanner scanner;

    public ConsoleContext(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
