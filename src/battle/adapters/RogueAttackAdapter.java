package battle.adapters;

import battle.battleStrategies.SpecialAttackStrategy;
import battle.classFight.player.RogueAttack;
import characters.interfaces.ICharacter;

public class RogueAttackAdapter extends SpecialAttackStrategy {
    RogueAttack rogueAttack;

    public RogueAttackAdapter(RogueAttack rogueAttack) {
        this.rogueAttack = rogueAttack;
    }

    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        rogueAttack.ChooseAttack(performer,target);
    }
}
