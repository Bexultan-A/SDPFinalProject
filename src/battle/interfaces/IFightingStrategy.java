package battle.interfaces;

import characters.interfaces.ICharacter;

public interface IFightingStrategy {
    void PerformAction(ICharacter performer, ICharacter target);
}
