package characters.decorators.classDecorators;
import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class RogueDecorator extends CharacterDecorator {
    public RogueDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Class: rogue";
    }

    @Override
    public double calculateAttack() {
        return super.calculateAttack() + super.getAgility()*3;
    }
}
