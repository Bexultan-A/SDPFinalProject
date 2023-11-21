package characters.decorators.race;

import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class GoblinDecorator extends CharacterDecorator {
    double agilityBonus = super.getAgility() * 2;
    public GoblinDecorator(ICharacter character) {
        super(character);
        super.setAgility(agilityBonus);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Goblin";
    }
}
