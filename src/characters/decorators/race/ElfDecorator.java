package characters.decorators.race;
import characters.baseDecorators.CharacterDecorator;
import characters.interfaces.ICharacter;

public class ElfDecorator extends CharacterDecorator {
    double intellectBonus = super.getIntellect() * 2;
    public ElfDecorator(ICharacter character) {
        super(character);
        super.setIntellect(intellectBonus);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Elf";
    }

}
