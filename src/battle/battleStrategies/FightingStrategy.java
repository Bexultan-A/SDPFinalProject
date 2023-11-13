package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class FightingStrategy implements IFightingStrategy {
    public FightingStrategy(ICharacter character) {
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
        character.setArmor(character.getArmor()*0.6);
        character.setStrength(character.getStrength()*1.2);
        character.setAgility(character.getAgility()*1.2);
        character.setIntellect(character.getIntellect()*1.2);
    }
}
