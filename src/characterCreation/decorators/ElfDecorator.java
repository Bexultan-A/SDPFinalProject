package characterCreation.decorators;

import characterCreation.baseDecorators.BaseRaceDecorator;
import characterCreation.interfaces.ICharacter;

public class ElfDecorator extends BaseRaceDecorator {
    int intellectBonus = 200;
    public ElfDecorator(ICharacter character) {
        super(character);
    }

    @Override
    public String raceAbility() {
        return "Live much longer";
    }

    @Override
    public int getIntellect() {
        return super.getIntellect() + intellectBonus;
    }

    @Override
    public int getMana() {
        return super.getMana() + getIntellect()*20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Race: Elf";
    }
}
