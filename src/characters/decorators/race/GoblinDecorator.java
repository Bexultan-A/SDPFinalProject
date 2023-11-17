package characters.decorators.race;

import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class GoblinDecorator extends CharacterDecorator {
    public GoblinDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Goblin";
    }
}
