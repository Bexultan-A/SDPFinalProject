package characterCreation;

import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;

import java.util.Scanner;

public class CharacterCreationManager {
    private final ICharacterFactory factory;
    private final Scanner scanner;

    public CharacterCreationManager(ICharacterFactory factory) {
        this.factory = factory;
        this.scanner = new Scanner(System.in);
    }

    public ICharacter createCharacter() {
        System.out.println("Welcome to character creation");
        System.out.println("Firstly, what is your character's name: ");
        String name = scanner.nextLine();
        ICharacter character = factory.createCharacter(name, 200, 100, 5, 5, 5);

        System.out.println("""
                Now, choose your race:\s
                 1. Elf
                 2. Orc
                 3. Goblin
                """);
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> character = factory.decorator("elf", character);
            case 2 -> character = factory.decorator("orc", character);
            case 3 -> character = factory.decorator("goblin", character);
            default -> {
                System.out.println("NO SUCH OPTION!!!, TRY AGAIN");
                scanner.nextLine();
                createCharacter();
            }
        }

        System.out.println("""
                Finally, choose your class:
                 1. Mage
                 2. Rogue
                 3. Warrior
                """);
        answer = scanner.nextInt();
        switch (answer) {
            case 1 -> {
                return factory.decorator("mage", character);
            }
            case 2 -> {
                return factory.decorator("rogue", character);
            }
            case 3 -> {
                return factory.decorator("warrior", character);
            }
            default -> {
                System.out.println("NO SUCH OPTION!!!, TRY AGAIN");
                scanner.nextLine();
                return createCharacter();
            }
        }
    }
}