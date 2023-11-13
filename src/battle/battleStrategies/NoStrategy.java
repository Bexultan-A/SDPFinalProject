package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class NoStrategy implements IFightingStrategy {
    @Override
    public void attack(ICharacter character, ICharacter enemy) {
        enemy.takeDamage(character.calculateAttack());
    }

    @Override
    public void resetStats(ICharacter character) {

    }
}
