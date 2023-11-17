package battle;

import battle.battleStrategies.DefenceStrategy;
import battle.battleStrategies.FightingStrategy;
import battle.battleStrategies.NoStrategy;
import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;
import battle.battleStrategies.NoStrategy;
import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class Battle {
    private ICharacter player;
    private ICharacter enemy;

    public ICharacter getPlayer() {
        return player;
    }

    public ICharacter getEnemy() {
        return enemy;
    }

    public Battle(ICharacter player, ICharacter enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void attack(ICharacter attacker, ICharacter enemy) {
        attacker.getFightingStrategy().attack(attacker, enemy);
    }

    public void resetBattle(ICharacter character, ICharacter newEnemy) {
        this.player = character;
        this.enemy = newEnemy;
    }
}
