package characters.decorators.race;

import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class OrcDecorator extends CharacterDecorator {
    double strengthBonus = super.getStrength() * 2;
    public OrcDecorator(ICharacter character) {
        super(character);
        super.setStrength(strengthBonus);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Orc";
    }
}
