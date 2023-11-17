package battle;

import battle.battleStrategies.*;
import java.util.Scanner;
import java.util.Random;
public class BattleController {
    private final Battle battle;
    public static Scanner scanner = new Scanner(System.in);
    public BattleController(Battle battle) {
        this.battle = battle;
    }

    public void chooseEnemyStrategy() {
        int randomChoice = (int) (Math.random() * 3) + 1;
        switch (randomChoice) {
            case 1:
                battle.getEnemy().setFightingStrategy(new FightingStrategy(battle.getEnemy()));
                break;
            case 2:
                battle.getEnemy().setFightingStrategy(new DefenceStrategy(battle.getEnemy()));
                break;
            case 3:
                battle.getEnemy().setFightingStrategy(new NoStrategy());
                break;
        }
    }

    public void chooseStrategy() {
        int choice;
        System.out.println("""
                Choose your strategy:\s
                1. Fighting
                2. Defence
                """);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                battle.getPlayer().setFightingStrategy(new FightingStrategy(battle.getPlayer()));
                break;
            case 2:
                battle.getPlayer().setFightingStrategy(new DefenceStrategy(battle.getPlayer()));
                break;
        }
    }

    public void playerAttack() {
        battle.attack(battle.getPlayer(), battle.getEnemy());
        if (battle.getEnemy().getHP() < 0) battle.getEnemy().setHP(0);
        System.out.println(battle.getPlayer().getName() +
                " has attacked " + battle.getEnemy().getName() +
                " on " + battle.getPlayer().calculateAttack() + " damage " +
                "\n" + battle.getEnemy().getName() + " now has " +
                battle.getEnemy().getHP() + " HP");
    }

    public void enemyAttack() {
        battle.attack(battle.getEnemy(), battle.getPlayer());
        if (battle.getPlayer().getHP() < 0) battle.getPlayer().setHP(0);
        System.out.println(battle.getEnemy().getName() +
                " has attacked " + battle.getPlayer().getName() +
                " on " + battle.getEnemy().calculateAttack() + " damage " +
                "\n" + battle.getPlayer().getName() + " now has " +
                battle.getPlayer().getHP() + " HP");
    }

    public boolean startBattle() {
        System.out.println("Player: " + battle.getPlayer().getDescription());
        System.out.println("Enemy: " + battle.getEnemy().getDescription());
        System.out.println("Battle has been started!!!");

        while (battle.getPlayer().getHP() > 0 && battle.getEnemy().getHP() > 0) {
            chooseEnemyStrategy();
            chooseStrategy();
            playerAttack();

            if (battle.getPlayer().getHP() <= 0) {
                System.out.println(battle.getPlayer().getName() + " IS DEFEATED");
                System.out.println(battle.getEnemy().getName() + " HAS WON!!!");
                return false;
            }

            enemyAttack();

            if (battle.getEnemy().getHP() <= 0) {
                System.out.println(battle.getEnemy().getName() + " IS DEFEATED");
                System.out.println(battle.getPlayer().getName() + " HAS WON!!!");
                return true;
            }
        }
        return false;
    }
}