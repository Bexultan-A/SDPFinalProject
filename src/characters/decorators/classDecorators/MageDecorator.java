package characters.decorators.classDecorators;

import characters.baseDecorators.BaseClassDecorator;
import characters.interfaces.ICharacter;

public class MageDecorator extends BaseClassDecorator {
    public MageDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public double calculateAttack() {
        return super.calculateAttack() + super.getIntellect()*3;
    }
}
