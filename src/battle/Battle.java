package battle;

import battle.battleStrategies.NoStrategy;
import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

public class Battle {
    ICharacter player;
    ICharacter enemy;
    IFightingStrategy fightingStrategy;

    public ICharacter getPlayer() {
        return player;
    }

    public ICharacter getEnemy() {
        return enemy;
    }

    public Battle(ICharacter player, ICharacter enemy) {
        this.player = player;
        this.enemy = enemy;
        this.fightingStrategy = new NoStrategy();
    }

    public void setFightingStrategy(IFightingStrategy fightingStrategy) {
        this.fightingStrategy = fightingStrategy;
    }
    public void attack(ICharacter attacker, ICharacter enemy) {
        fightingStrategy.attack(attacker, enemy);
    }
}
