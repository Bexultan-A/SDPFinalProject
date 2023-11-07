import characterCreation.Character;
import characterCreation.decorators.ElfDecorator;
import characterCreation.interfaces.ICharacter;

public class Main {
    public static void main(String[] args) {
        ICharacter character = new Character("smbd",200,3,3,3);
        ICharacter elf = new ElfDecorator(character);

        System.out.println(character.getDescription() + " Intellect: " + character.getIntellect() + " Mana: " + character.getMana());
        System.out.println();
        System.out.println(elf.getDescription() + " Intellect: " + elf.getIntellect() + " Mana: " + elf.getMana());
    }
}