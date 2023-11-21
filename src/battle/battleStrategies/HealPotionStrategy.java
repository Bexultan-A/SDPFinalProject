package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class HealPotionStrategy implements IFightingStrategy {
    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        performer.heal(60);
        System.out.println(performer.getName() + " Healed on 60 HP, and now has " + performer.getHP());
    }
}
