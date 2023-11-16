package characterCreation.interfaces;

import characters.interfaces.ICharacter;

public interface ICharacterFactory {
    ICharacter createCharacter(String name, double HP, double armor, double strength, double agility, double intellect);
    ICharacter decorator(String decorator, ICharacter character);
}
