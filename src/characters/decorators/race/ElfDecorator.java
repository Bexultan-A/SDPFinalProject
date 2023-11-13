package characters.decorators.race;

import characters.baseDecorators.BaseRaceDecorator;
import characters.interfaces.ICharacter;

public class ElfDecorator extends BaseRaceDecorator {
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
