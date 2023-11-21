package battle.classFight.enemy;

import battle.classFight.player.MageAttack;
import characters.interfaces.ICharacter;

public class EnemyMageAttack extends MageAttack {
    @Override
    public void ChooseSpell(ICharacter attacker, ICharacter target) {
        int randomChoice = (int) (Math.random() * 2) + 1;
        switch (randomChoice) {
            case 1 -> LightningSpell(attacker, target);
            case 2 -> FireBall(attacker, target);
        }
    }

    @Override
    public void LightningSpell(ICharacter attacker, ICharacter target) {
        super.LightningSpell(attacker, target);
    }

    @Override
    public void FireBall(ICharacter attacker, ICharacter target) {
        super.FireBall(attacker, target);
    }
}
