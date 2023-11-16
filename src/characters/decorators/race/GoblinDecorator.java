package characters.decorators.race;

import characters.baseDecorators.BaseRaceDecorator;
import characters.interfaces.ICharacter;

public class GoblinDecorator extends BaseRaceDecorator {
    public GoblinDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Goblin";
    }
}
