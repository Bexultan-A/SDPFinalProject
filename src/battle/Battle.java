package battle;

import characters.interfaces.ICharacter;

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
        attacker.getFightingStrategy().PerformAction(attacker, enemy);
    }
}
