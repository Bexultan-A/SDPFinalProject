package battle.adapters;

import battle.battleStrategies.SpecialAttackStrategy;
import battle.classFight.player.WarriorAttack;
import characters.interfaces.ICharacter;

public class WarriorAttackAdapter extends SpecialAttackStrategy {
    WarriorAttack warriorAttack;

    public WarriorAttackAdapter(WarriorAttack warriorAttack) {
        this.warriorAttack = warriorAttack;
    }

    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        warriorAttack.ChooseAttack(performer,target);
    }
}
