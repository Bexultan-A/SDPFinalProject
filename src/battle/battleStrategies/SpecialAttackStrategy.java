package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class SpecialAttackStrategy implements IFightingStrategy {
    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        System.out.println(performer.getDescription());
    }
}
