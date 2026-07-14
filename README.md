# MenuCLI

A platform-agnostic menu framework for Java and Kotlin.

Define menus once and run them across multiple platforms:

- Console
- Swing
- Discord (JDA)

## Modules

| Module | Description                       |
|--------|-----------------------------------|
| `engine` | Core menu API                     |
| `console` | Console `MenuView` implementation |
| `swing` | Swing `MenuView` implementation   |
| `discord-jda` | Discord JDA `MenuView` implementation       |

The `engine` module is platform-independent. Platform modules provide `MenuView` implementations for rendering menus and handling user interaction.

## Defining Menus (Java)

Menus are constructed using the Builder API.

```java
Action addition = new ActionBuilder()
    .setComponent(new Component("Addition", "Adds two numbers"))
    .setAction(context -> System.out.println("Adding..."))
    .build();

Action subtraction = new ActionBuilder()
    .setComponent(new Component("Subtraction", "Subtracts two numbers"))
    .setAction(context -> System.out.println("Subtracting..."))
    .build();

Menu calculator = new MenuBuilder<Component>()
    .setComponent(new Component("Calculator", "Choose an operation"))
    .addOption(addition)
    .addOption(subtraction)
    .build();

Action exit = new ActionBuilder()
    .setComponent(new Component("Exit", "Terminates the application"))
    .setAction(context -> System.exit(0))
    .build();

Menu mainMenu = new MenuBuilder<Component>()
    .setComponent(new Component("Main Menu", "Demo application"))
    .addOption(calculator)
    .addOption(exit)
    .build();
```

## Defining Menus (Kotlin)

Menus can also be defined using the Kotlin DSL.

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
```

## Running a Menu

Create the appropriate `MenuView` for your target platform.

### Console

```java
Scanner scanner = new Scanner(System.in);
ConsoleContext context = new ConsoleContext(scanner);

MenuView view = new ConsoleView(context);

new MenuRunner(view).start(mainMenu);
```

### Swing

```java
JComponent component = new JPanel();
SwingContext context = new SwingContext(component);

MenuView view = new SwingView(context);

new MenuRunner(view).start(mainMenu);
```

### Discord (JDA)
```java
User user = event.getUser();
MessageChannel channel = event.getMessageChannel();
JDAContext context = new JDAContext(user, channel);

MenuView view = new JDAMessageView(context);

new MenuRunner(view).start(mainMenu);
```

## License

MIT
