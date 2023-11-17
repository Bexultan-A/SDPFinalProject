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

        System.out.println("Now, choose your race: elf, orc, or goblin");
        String race = scanner.nextLine();
        character = factory.decorator(race, character);

        System.out.println("Finally, choose your class: mage, rogue, or warrior");
        String characterClass = scanner.nextLine();
        return factory.decorator(characterClass, character);
    }
}