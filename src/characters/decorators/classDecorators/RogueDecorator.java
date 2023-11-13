package characters.decorators.classDecorators;

import characters.baseDecorators.BaseClassDecorator;
import characters.interfaces.ICharacter;

public class RogueDecorator extends BaseClassDecorator {
    public RogueDecorator(ICharacter character) {
        super(character);
    }
}