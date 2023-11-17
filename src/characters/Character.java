package characters;

import battle.battleStrategies.NoStrategy;
import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class Character implements ICharacter {
    String name;
    double HP;
    double armor;
    double mana;
    double strength;
    double agility;
    double intellect;
    IFightingStrategy fightingStrategy;

    public Character(String name, double HP, double armor, double strength, double agility, double intellect) {
        this.name = name;
        this.HP = HP;
        this.armor = armor;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.mana = this.intellect * 20;
        this.fightingStrategy = new NoStrategy();
    }

    @Override
    public String getDescription() {
        return "Base character";
    }

    @Override
    public double calculateAttack() {
        return strength*3 + agility*2;
    }

    @Override
    public void heal(double HP) {
        setHP(getHP() + HP);
    }

    @Override
    public void takeDamage(double damage) {
        setHP(getHP() - (damage-(getArmor()/10)));
    }

    @Override
    public double getArmor() {
        return armor;
    }
    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public double getHP() {
        return HP;
    }
    @Override
    public void setHP(double HP) {
        this.HP = HP;
    }
    @Override
    public double getMana() {
        return mana;
    }
    @Override
    public void setMana(double mana) {
        this.mana = mana;
    }
    @Override
    public double getStrength() {
        return strength;
    }
    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }
    @Override
    public double getAgility() {
        return agility;
    }
    @Override
    public void setAgility(double agility) {
        this.agility = agility;
    }
    @Override
    public double getIntellect() {
        return intellect;
    }
    @Override
    public void setIntellect(double intellect) {
        this.intellect = intellect;
        setMana(intellect * 20);
    }

    public IFightingStrategy getFightingStrategy() {
        return fightingStrategy;
    }

    public void setFightingStrategy(IFightingStrategy fightingStrategy) {
        this.fightingStrategy = fightingStrategy;
    }

    @Override
    public void update() {
        System.out.println("Congratulations " + getName() + "You've reached next level of the tower" );
    }
}
