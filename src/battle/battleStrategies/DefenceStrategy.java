package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class DefenceStrategy implements IFightingStrategy {
    public DefenceStrategy(ICharacter character) {
        changeStats(character);
    }

    @Override
    public void attack(ICharacter character, ICharacter enemy) {
        enemy.takeDamage(character.calculateAttack());
    }

    @Override
    public void resetStats(ICharacter character) {

    }

    private void changeStats(ICharacter character) {
        character.setArmor(character.getArmor()*1.6);
        character.setStrength(character.getStrength()*0.8);
        character.setAgility(character.getAgility()*0.8);
        character.setIntellect(character.getIntellect()*0.8);
    }
}
