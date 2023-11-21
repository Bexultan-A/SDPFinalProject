package characters.decorators.classDecorators;
import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class MageDecorator extends CharacterDecorator {
    public MageDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Class: mage";
    }

    @Override
    public double calculateAttack() {
        return super.calculateAttack() + super.getIntellect()*3;
    }
}
