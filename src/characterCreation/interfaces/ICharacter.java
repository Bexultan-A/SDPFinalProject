package characterCreation.interfaces;

public interface ICharacter {
    String getDescription();
    String attack();
    int getStrength();
    int getAgility();
    int getIntellect();
    int getMana();
    String usePotion();
    String getDamage();
}
