package battle.adapters;

import battle.battleStrategies.CommonAttackStrategy;
import battle.battleStrategies.SpecialAttackStrategy;
import battle.classFight.player.MageAttack;
import characters.interfaces.ICharacter;

public class MageAttackAdapter extends SpecialAttackStrategy {
    MageAttack mageAttack;

    public MageAttackAdapter(MageAttack mageAttack) {
        this.mageAttack = mageAttack;
    }

    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        mageAttack.ChooseSpell(performer,target);
    }
}
