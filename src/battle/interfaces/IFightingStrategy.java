package battle.interfaces;

import characters.interfaces.ICharacter;

public interface IFightingStrategy {
    void attack(ICharacter character, ICharacter enemy);
    void resetStats(ICharacter character);
}
