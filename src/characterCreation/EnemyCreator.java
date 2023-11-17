package characterCreation;

import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;

import java.util.ArrayList;
import java.util.Random;

public class EnemyCreator {
    private final ICharacterFactory factory;

    public EnemyCreator(ICharacterFactory factory) {
        this.factory = factory;
    }

    public ICharacter createEnemy() {
        String[] races = {"elf", "orc", "goblin"};
        String[] classes = {"mage", "rogue", "warrior"};

        ICharacter enemy = factory.createCharacter("Enemy", 200, 100, 5, 5, 5);
        String race = races[new Random().nextInt(races.length)];
        enemy = factory.decorator(race, enemy);
        String enemyClass = classes[new Random().nextInt(classes.length)];
        return factory.decorator(enemyClass, enemy);
    }
}