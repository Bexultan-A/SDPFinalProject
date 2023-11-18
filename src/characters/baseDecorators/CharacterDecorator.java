package characters.baseDecorators;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class CharacterDecorator implements ICharacter {
    ICharacter character;

    public CharacterDecorator(ICharacter character) {
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getDescription();
    }

    @Override
    public double calculateAttack() {
        return character.calculateAttack();
    }

    @Override
    public void heal(double HP) {
        character.heal(HP);
    }

    @Override
    public void takeDamage(double damage) {
        character.takeDamage(damage);
    }

    @Override
    public double getArmor() {
        return character.getArmor();
    }

    @Override
    public void setArmor(double armor) {
        character.setArmor(armor);
    }

    @Override
    public String getName() {
        return character.getName();
    }

    @Override
    public void setName(String name) {
        character.setName(name);
    }

    @Override
    public double getHP() {
        return character.getHP();
    }

    @Override
    public void setHP(double HP) {
        character.setHP(HP);
    }

    @Override
    public double getMana() {
        return character.getMana();
    }

    @Override
    public void setMana(double mana) {
        character.setMana(mana);
    }

    @Override
    public double getStrength() {
        return character.getStrength();
    }

    @Override
    public void setStrength(double strength) {
        character.setStrength(strength);
    }

    @Override
    public double getAgility() {
        return character.getAgility();
    }

    @Override
    public void setAgility(double agility) {
        character.setAgility(agility);
    }

    @Override
    public double getIntellect() {
        return character.getIntellect();
    }

    @Override
    public void setIntellect(double intellect) {
        character.setIntellect(intellect);
    }

    @Override
    public IFightingStrategy getFightingStrategy() {
        return character.getFightingStrategy();
    }

    @Override
    public void setFightingStrategy(IFightingStrategy fightingStrategy) {
        character.setFightingStrategy(fightingStrategy);
    }

    @Override
    public void update(String message) {
        character.update(message);
    }
}
