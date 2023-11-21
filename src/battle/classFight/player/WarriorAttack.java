package battle.classFight.player;

import battle.battleStrategies.DefenceStrategy;
import characters.interfaces.ICharacter;

import java.util.Scanner;

public class WarriorAttack {
    Scanner scanner;

    public WarriorAttack() {
        this.scanner = new Scanner(System.in);
    }

    public void ChooseAttack(ICharacter attacker, ICharacter target) {
        System.out.println("""
                Choose spell:
                 1. Charge Attack
                 2. Shield Bash
                """);
        int spell = scanner.nextInt();
        switch (spell) {
            case 1 -> ChargeAttack(attacker,target);
            case 2 -> ShieldBash(attacker,target);
            default -> {
                System.out.println("There is no such option");
                ChooseAttack(attacker,target);
            }
        }
    }

    public void ChargeAttack(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 30) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getStrength()*10;
        attacker.setMana(attacker.getMana()-30);
        target.takeDamage(damage);
        if (target.getHP() < 0) target.setHP(0);
        System.out.println("CHARGE ATTACK");
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + damage + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP");
    }

    public void ShieldBash(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 40) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getStrength()*5;
        attacker.setMana(attacker.getMana()-40);
        attacker.setArmor(attacker.getArmor()+20);
        target.takeDamage(damage);
        if (target.getHP() < 0) target.setHP(0);
        System.out.println("SHIELD BASH");
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + damage + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP, also " +
                attacker.getName() + " now has " + attacker.getArmor());
    }
}
