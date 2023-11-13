package characters.interfaces;

public interface ICharacter {
    String getDescription();
    double calculateAttack();
    void heal(double HP);
    void takeDamage(double damage);
    double getArmor();
    void setArmor(double armor);
    String getName();
    void setName(String name);
    double getHP();
    void setHP(double HP);
    double getMana();
    void setMana(double mana);
    double getStrength();
    void setStrength(double strength);
    double getAgility();
    void setAgility(double agility);
    double getIntellect();
    void setIntellect(double intellect);
}
