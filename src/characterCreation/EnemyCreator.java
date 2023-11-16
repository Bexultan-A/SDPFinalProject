package characterCreation;

import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;

import java.util.ArrayList;

public class EnemyCreator {
    String[] races = {"elf", "orc", "goblin"};
    String[] classes = {"mage", "rogue", "warrior"};

    public ICharacter createEnemy() {
        ICharacterFactory factory = new CharacterFactory();
        ICharacter character;
        character = factory.createCharacter("Enemy",200,100,5,5,5);
        character = factory.decorator(races[(int) (Math.random()*3)], character);
        character = factory.decorator(classes[(int) (Math.random()*3)], character);
        return character;
    }
}
