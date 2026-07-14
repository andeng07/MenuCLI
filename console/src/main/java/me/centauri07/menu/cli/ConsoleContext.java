package me.centauri07.menu.cli;

import me.centauri07.menu.engine.core.Context;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleContext implements Context {
    private Scanner scanner;

    public ConsoleContext(@NotNull Scanner scanner) {
        Objects.requireNonNull(scanner);

        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
