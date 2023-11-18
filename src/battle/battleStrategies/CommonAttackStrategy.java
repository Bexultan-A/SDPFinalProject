package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class CommonAttackStrategy implements IFightingStrategy {
    @Override
    public void PerformAction(ICharacter attacker, ICharacter target) {
        target.takeDamage(attacker.calculateAttack());
        if (target.getHP() < 0) target.setHP(0);
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + attacker.calculateAttack() + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP");
    }
}
