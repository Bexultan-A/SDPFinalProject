package battle.classFight.player;

import characters.interfaces.ICharacter;

import java.util.Scanner;

public class RogueAttack {
    Scanner scanner;

    public RogueAttack() {
        this.scanner = new Scanner(System.in);
    }

    public void ChooseAttack(ICharacter attacker, ICharacter target) {
        System.out.println("""
                Choose spell:
                 1. Sneak Attack
                 2. Back Stab
                """);
        int spell = scanner.nextInt();
        switch (spell) {
            case 1 -> SneakAttack(attacker,target);
            case 2 -> BackStab(attacker,target);
            default -> {
                System.out.println("There is no such option");
                ChooseAttack(attacker,target);
            }
        }
    }

    public void SneakAttack(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 40) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getAgility()*10;
        attacker.setMana(attacker.getMana()-40);
        target.takeDamage(damage);
        if (target.getHP() < 0) target.setHP(0);
        System.out.println("CHARGE ATTACK");
        System.out.println(attacker.getName() +
                " has attacked " + target.getName() +
                " on " + damage + " damage " +
                "\n" + target.getName() + " now has " +
                target.getHP() + " HP");
    }

    public void BackStab(ICharacter attacker, ICharacter target) {
        if (attacker.getMana() < 50) {
            System.out.println("Not enough Mana");
        }
        double damage = attacker.getAgility()*5;
        attacker.setMana(attacker.getMana()-50);
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
