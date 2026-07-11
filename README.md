# MenuCLI

A lightweight terminal menu framework for Java and Kotlin.

MenuCLI handles menu navigation and action execution so you can focus on implementing your application's functionality.

## Features

- Hierarchical menus
- Java builder API
- Kotlin DSL
- Executable menu actions
- Automatic menu navigation
- Lightweight and dependency-free

## Installation

Clone the repository and include it in your project.

## Kotlin DSL

Build hierarchical menus declaratively using the Kotlin DSL.

```kotlin
val mainMenu = menu("Main Menu", "Demo application") {
    submenu("Calculator", "Choose an operation") {
        action("Addition", "Adds two numbers") {
            println("Adding...")
        }

        action("Subtraction", "Subtracts two numbers") {
            println("Subtracting...")
        }
    }

    action("Exit", "Terminates the application") {
        exitProcess(0)
    }
}

MenuRunner(mainMenu, Scanner(System.`in`)).start()
```

The DSL automatically constructs the menu hierarchy, making complex menus concise and easy to read.

## Java Builder API

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

MenuCLI automatically renders menus, handles navigation, and executes the selected actions.

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
