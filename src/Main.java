import battle.Battle;
import battle.BattleUI;
import characterCreation.CharacterFactory;
import characterCreation.EnemyCreator;
import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ICharacter character = createCharacter();
        EnemyCreator enemyCreator = new EnemyCreator();
        ICharacter enemy = enemyCreator.createEnemy();

        BattleUI battle = new BattleUI(new Battle(character, enemy));
        battle.startBattle();
    }

    private static ICharacter createCharacter() {
        ICharacterFactory factory = new CharacterFactory();
        Scanner scanner = new Scanner(System.in);
        ICharacter character;

        System.out.println("Welcome to character creation");
        System.out.println("Firstly what is your characters name: ");
        String name = scanner.nextLine();
        character = factory.createCharacter(name,200,100,5,5,5);
        System.out.println("Now, choose your race: elf, orc or goblin");
        String race = scanner.nextLine();
        character = factory.decorator(race, character);
        System.out.println("Finally, choose your class: mage, rogue or warrior");
        String chClass = scanner.nextLine();
        character = factory.decorator(chClass, character);

        return character;
    }
}