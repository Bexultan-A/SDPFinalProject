package characters;

public class CharacterAttributes {
    private double HP;
    private double armor;
    private double strength;
    private double agility;
    private double intellect;
    private double mana;

    public CharacterAttributes(double HP, double armor, double strength, double agility, double intellect, double mana) {
        this.HP = HP;
        this.armor = armor;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.mana = mana;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getIntellect() {
        return intellect;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    // Constructor, getters, and setters
}