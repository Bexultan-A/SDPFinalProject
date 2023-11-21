package characters.interfaces;

import battle.interfaces.IFightingStrategy;

public interface IHaveFightingStrategy {
    IFightingStrategy getFightingStrategy();
    void setFightingStrategy(IFightingStrategy fightingStrategy);
}
