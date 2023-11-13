package battle;

import battle.battleStrategies.DefenceStrategy;
import battle.battleStrategies.FightingStrategy;
import battle.battleStrategies.NoStrategy;

import java.util.Scanner;

public class BattleUI {
    Battle battle;
    Scanner scanner;

    public BattleUI(Battle battle) {
        this.battle = battle;
        this.scanner = new Scanner(System.in);
    }

    public void startBattle() {
        System.out.println("Battle has been started!!!");
        chooseStrategy();
        while (true) {
            if (battle.getPlayer().getHP() > 0) {
                playerAttack();
            } else {
                System.out.println(battle.getPlayer().getName() + " IS DEFEATED");
                System.out.println(battle.getEnemy().getName() + " HAS WON!!!");
                break;
            }
            if (battle.getEnemy().getHP() > 0) {
                enemyAttack();
            } else {
                System.out.println(battle.getEnemy().getName() + " IS DEFEATED");
                System.out.println(battle.getPlayer().getName() + " HAS WON!!!");
                break;
            }
        }
    }

    public void playerAttack() {
        battle.attack(battle.getPlayer(), battle.getEnemy());
        System.out.println(battle.getPlayer().getName() +
                " has attacked " + battle.getEnemy().getName() +
                " on " + battle.getPlayer().calculateAttack() + " damage " +
                "\n" + battle.getEnemy().getName() + " now has " +
                battle.getEnemy().getHP() + " HP");
    }

    public void enemyAttack() {
        battle.attack(battle.getEnemy(), battle.getPlayer());
        System.out.println(battle.getEnemy().getName() +
                " has attacked " + battle.getPlayer().getName() +
                " on " + battle.getEnemy().calculateAttack() + " damage " +
                "\n" + battle.getPlayer().getName() + " now has " +
                battle.getPlayer().getHP() + " HP");
    }

    public void chooseStrategy() {
        int choice;
        System.out.println("""
                Choose your strategy:\s
                1. Fighting
                2. Defence
                3. No Strategy
                """);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                battle.setFightingStrategy(new FightingStrategy(battle.getPlayer()));
            case 2:
                battle.setFightingStrategy(new DefenceStrategy(battle.getPlayer()));
            case 3:
                battle.setFightingStrategy(new NoStrategy());
        }
    }
}
