package battle;

import battle.adapters.MageAttackAdapter;
import battle.adapters.RogueAttackAdapter;
import battle.adapters.WarriorAttackAdapter;
import battle.battleStrategies.*;
import battle.classFight.enemy.EnemyMageAttack;
import battle.classFight.enemy.EnemyRogueAttack;
import battle.classFight.enemy.EnemyWarriorAttack;
import battle.classFight.player.MageAttack;
import battle.classFight.player.RogueAttack;
import battle.classFight.player.WarriorAttack;
import battle.interfaces.IFightingStrategy;
import characters.interfaces.ICharacter;

import java.util.Scanner;

public class BattleController {
    private final Battle battle;
    public static Scanner scanner = new Scanner(System.in);
    public BattleController(Battle battle) {
        this.battle = battle;
    }

    public void chooseEnemyStrategy() {
        int randomChoice = (int) (Math.random() * 5) + 1;
        switch (randomChoice) {
            case 1 -> {
                if (battle.getEnemy().getDescription().contains("mage")) {
                    MageAttack mageAttack = new EnemyMageAttack();
                    battle.getEnemy().setFightingStrategy(new MageAttackAdapter(mageAttack));
                } else if (battle.getEnemy().getDescription().contains("warrior")) {
                    WarriorAttack warriorAttack = new EnemyWarriorAttack();
                    battle.getEnemy().setFightingStrategy(new WarriorAttackAdapter(warriorAttack));
                } else if (battle.getEnemy().getDescription().contains("rogue")) {
                    RogueAttack rogueAttack = new EnemyRogueAttack();
                    battle.getEnemy().setFightingStrategy(new RogueAttackAdapter(rogueAttack));
                } else {
                    battle.getEnemy().setFightingStrategy(new SpecialAttackStrategy());
                }
            }
            case 2 -> battle.getEnemy().setFightingStrategy(new DefenceStrategy());
            case 3 -> battle.getEnemy().setFightingStrategy(new HealPotionStrategy());
            case 4 -> battle.getEnemy().setFightingStrategy(new CommonAttackStrategy());
            case 5 -> battle.getEnemy().setFightingStrategy(new ManaPotionStrategy());
        }
    }

    public void chooseStrategy() {
        int choice;
        System.out.println("""
                Choose your strategy:\s
                1. Attack
                2. Special Attack
                3. Defence
                4. Heal
                5. Mana Potion
                """);
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                battle.getPlayer().setFightingStrategy(new CommonAttackStrategy());
            }
            case 2 -> {
                if (battle.getPlayer().getDescription().contains("mage")) {
                    MageAttack mageAttack = new MageAttack();
                    battle.getPlayer().setFightingStrategy(new MageAttackAdapter(mageAttack));
                } else if (battle.getPlayer().getDescription().contains("warrior")) {
                    WarriorAttack warriorAttack = new WarriorAttack();
                    battle.getPlayer().setFightingStrategy(new WarriorAttackAdapter(warriorAttack));
                } else if (battle.getPlayer().getDescription().contains("rogue")) {
                    RogueAttack rogueAttack = new RogueAttack();
                    battle.getPlayer().setFightingStrategy(new RogueAttackAdapter(rogueAttack));
                } else {
                    battle.getPlayer().setFightingStrategy(new SpecialAttackStrategy());
                }
            }
            case 3 -> battle.getPlayer().setFightingStrategy(new DefenceStrategy());
            case 4 -> battle.getPlayer().setFightingStrategy(new HealPotionStrategy());
            case 5 -> battle.getPlayer().setFightingStrategy(new ManaPotionStrategy());
            default -> {
                System.out.println("No such option");
                chooseStrategy();
            }
        }
    }

    public void playerTurn() {
        chooseStrategy();
        battle.getPlayer().getFightingStrategy().PerformAction(battle.getPlayer(), battle.getEnemy());
    }

    public void enemyTurn() {
        chooseEnemyStrategy();
        battle.getEnemy().getFightingStrategy().PerformAction(battle.getEnemy(), battle.getPlayer());
    }

    public boolean startBattle() {
        resetStats(battle.getPlayer());
        System.out.println("Player: " + battle.getPlayer().getDescription());
        System.out.println("Enemy: " + battle.getEnemy().getDescription());
        System.out.println("Battle has been started!!!");

        while (battle.getPlayer().getHP() > 0 && battle.getEnemy().getHP() > 0) {

            resetArmorForCharacter(battle.getPlayer());
            playerTurn();

            if (battle.getPlayer().getHP() <= 0) {
                System.out.println(battle.getPlayer().getName() + " IS DEFEATED");
                System.out.println(battle.getEnemy().getName() + " HAS WON!!!");
                return false;
            }

            resetArmorForCharacter(battle.getEnemy());
            enemyTurn();

            if (battle.getEnemy().getHP() <= 0) {
                System.out.println(battle.getEnemy().getName() + " IS DEFEATED");
                System.out.println(battle.getPlayer().getName() + " HAS WON!!!");
                return true;
            }
        }
        return false;
    }

    public void resetArmorForCharacter(ICharacter character) {
        character.setArmor(100);
    }
    public void resetStats(ICharacter character) {
        character.setHP(200);
        character.setArmor(100);
        character.setMana(character.getIntellect()*20);
    }
}