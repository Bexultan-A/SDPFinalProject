package characterCreation;

import characterCreation.interfaces.ICharacter;

public class Character implements ICharacter {
    String name;
    int HP;
    int mana;
    int strength;
    int agility;
    int intellect;

    public Character(String name, int HP, int strength, int agility, int intellect) {
        this.name = name;
        this.HP = HP;
        this.mana = intellect * 20;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public String getDescription() {
        return "Character: " + name;
    }

    @Override
    public String attack() {
        return null;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getIntellect() {
        return intellect;
    }

    @Override
    public int getMana() {
        return mana;
    }


    @Override
    public String usePotion() {
        return "Heal potion used";
    }

    @Override
    public String getDamage() {
        return "Got damage";
    }
}
