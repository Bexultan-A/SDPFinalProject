package battle.classFight.player;

import characters.interfaces.ICharacter;

import java.util.Scanner;

public class MageAttack {
    Scanner scanner;
    public MageAttack() {
        scanner = new Scanner(System.in);
    }

    public void ChooseSpell(ICharacter attacker, ICharacter target) {
        System.out.println("""
                Choose spell:
                 1. Lightning
                 2. FireBall
                """);
        int spell = scanner.nextInt();
        switch (spell) {
            case 1 -> LightningSpell(attacker,target);
            case 2 -> FireBall(attacker,target);
            default -> {
                System.out.println("There is no such option");
                ChooseSpell(attacker,target);
            }
        }
    }

    public void LightningSpell(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 100) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getIntellect()*20;
        attacker.setMana(attacker.getMana()-100);
        target.takeDamage(damage);
        if (target.getHP() < 0) target.setHP(0);
        System.out.println("LIGHTNING SPELL");
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + damage + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP");
    }

    public void FireBall(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 50) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getIntellect()*10;
        attacker.setMana(attacker.getMana()-50);
        target.takeDamage(damage);
        System.out.println("FIRE BALL");
        if (target.getHP() < 0) target.setHP(0);
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + damage + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP");
    }
}
