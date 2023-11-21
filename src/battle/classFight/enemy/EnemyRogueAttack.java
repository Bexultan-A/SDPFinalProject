package battle.classFight.enemy;

import battle.classFight.player.RogueAttack;
import characters.interfaces.ICharacter;

public class EnemyRogueAttack extends RogueAttack {
    @Override
    public void ChooseAttack(ICharacter attacker, ICharacter target) {
        int randomChoice = (int) (Math.random() * 2) + 1;
        switch (randomChoice) {
            case 1 -> SneakAttack(attacker, target);
            case 2 -> BackStab(attacker, target);
        }
    }
}
