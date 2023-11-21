package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class ManaPotionStrategy implements IFightingStrategy {
    @Override
    public void PerformAction(ICharacter performer, ICharacter target) {
        performer.setMana(performer.getMana()+60);
        System.out.println(performer.getName() + " Healed his Mana on 60 HP, and now has " + performer.getMana());
    }
}
