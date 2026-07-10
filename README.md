
# MenuCLI

A lightweight terminal menu framework for Java

MenuCLI handles menu navigation and action execution so you can focus on implementing your application's functionality.

## Features

- Hierarchical menus
- Menu builder
- Executable menu actions
- Automatic navigation
- Lightweight and dependency-free

## Installation

Clone the repository and include it in your project.

## Quick Start

### 1. Create your actions

```java
MenuAction hello = new MenuAction(
    "Hello",
    "Prints a greeting",
    () -> System.out.println("Hello, world!")
);

MenuAction exit = new MenuAction(
    "Exit",
    "Terminates the application",
    () -> System.exit(0)
);
```

### 2. Build your menu

```java
Menu mainMenu = new MenuBuilder()
    .setName("Main Menu")
    .setDescription("Select an option")
    .addOption(hello)
    .addOption(exit)
    .build();
```

### 3. Run your menu

```java
Scanner scanner = new Scanner(System.in);

new MenuRunner(mainMenu, scanner).start();
```

MenuCLI will render the menu, handle navigation, and execute the selected actions.

## Nested Menus

```java
Menu calculator = new MenuBuilder()
    .setName("Calculator")
    .setDescription("Choose an operation")
    .addOption(new MenuAction(
        "Addition",
        "Adds two numbers",
        () -> System.out.println("Adding...")
    ))
    .build();

Menu mainMenu = new MenuBuilder()
    .setName("Main Menu")
    .setDescription("Demo application")
    .addOption(calculator)
    .addOption(new MenuAction(
        "Exit",
        "Terminates the application",
        () -> System.exit(0)
    ))
    .build();

new MenuRunner(mainMenu, new Scanner(System.in)).start();
```

Selecting a submenu automatically navigates into it, while selecting **Back** returns to the previous menu.

## License

MIT
