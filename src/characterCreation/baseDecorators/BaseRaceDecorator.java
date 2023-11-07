package characterCreation.baseDecorators;

import characterCreation.interfaces.ICharacter;

public abstract class BaseRaceDecorator implements ICharacter {
    ICharacter character;

    public BaseRaceDecorator(ICharacter character) {
        this.character = character;
    }

    public abstract String raceAbility();

    @Override
    public String getDescription() {
        return character.getDescription();
    }

    @Override
    public String attack() {
        return character.attack();
    }

    @Override
    public int getStrength() {
        return character.getStrength();
    }

    @Override
    public int getAgility() {
        return character.getAgility();
    }

    @Override
    public int getIntellect() {
        return character.getIntellect();
    }

    @Override
    public int getMana() {
        return character.getMana();
    }

    @Override
    public String usePotion() {
        return character.usePotion();
    }

    @Override
    public String getDamage() {
        return character.getDamage();
    }
}
