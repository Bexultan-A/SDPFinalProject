package characters.decorators.classDecorators;
import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class WarriorDecorator extends CharacterDecorator {
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
