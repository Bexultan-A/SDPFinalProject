package characterCreation;

import characterCreation.interfaces.ICharacterFactory;
import characters.Character;
import characters.decorators.classDecorators.MageDecorator;
import characters.decorators.classDecorators.RogueDecorator;
import characters.decorators.classDecorators.WarriorDecorator;
import characters.decorators.race.ElfDecorator;
import characters.decorators.race.GoblinDecorator;
import characters.decorators.race.OrcDecorator;
import characters.interfaces.ICharacter;

public class CharacterFactory implements ICharacterFactory {
    @Override
    public ICharacter createCharacter(String name, double HP, double armor, double strength, double agility, double intellect) {
        return new Character(name, HP, armor, strength, agility, intellect);
    }

    @Override
    public ICharacter decorator(String decorator, ICharacter character) {
        switch (decorator) {
            case "mage" -> {
                return new MageDecorator(character);
            }
            case "rogue" -> {
                return new RogueDecorator(character);
            }
            case "warrior" -> {
                return new WarriorDecorator(character);
            }
            case "elf" -> {
                return new ElfDecorator(character);
            }
            case "orc" -> {
                return new OrcDecorator(character);
            }
            case "goblin" -> {
                return new GoblinDecorator(character);
            }
        }
        System.out.println("There is no such option");
        return character;
    }
}
