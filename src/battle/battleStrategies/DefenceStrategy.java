package battle.battleStrategies;

import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class DefenceStrategy implements IFightingStrategy {

    @Override
    public void PerformAction(ICharacter character, ICharacter enemy) {
        character.setArmor(character.getArmor()+60);
        System.out.println(character.getName() + " Using Defence Strategy, now his armor is " + character.getArmor());
    }
}
