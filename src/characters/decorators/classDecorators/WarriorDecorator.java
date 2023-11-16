package characters.decorators.classDecorators;

import characters.baseDecorators.BaseClassDecorator;
import characters.interfaces.ICharacter;

public class WarriorDecorator extends BaseClassDecorator {
    public WarriorDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Class: warrior";
    }

    @Override
    public double calculateAttack() {
        return super.calculateAttack() + super.getStrength()*3;
    }
}
