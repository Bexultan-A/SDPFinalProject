package battle.classFight.enemy;

import battle.classFight.player.WarriorAttack;
import characters.interfaces.ICharacter;

public class EnemyWarriorAttack extends WarriorAttack {
    @Override
    public void ChooseAttack(ICharacter attacker, ICharacter target) {
        int randomChoice = (int) (Math.random() * 2) + 1;
        switch (randomChoice) {
            case 1 -> ChargeAttack(attacker, target);
            case 2 -> ShieldBash(attacker, target);
        }
    }
}
