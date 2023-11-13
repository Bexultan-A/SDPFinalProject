import battle.Battle;
import battle.BattleUI;
import characters.Character;
import characters.decorators.classDecorators.MageDecorator;
import characters.decorators.classDecorators.WarriorDecorator;
import characters.decorators.race.ElfDecorator;
import characters.decorators.race.OrcDecorator;
import characters.interfaces.ICharacter;

public class Main {
    public static void main(String[] args) {
        ICharacter character = new Character("Player", 200,100,5,5,5);
        ICharacter enemy = new Character("Enemy", 200,100,5,5,5);

        character = new MageDecorator(new ElfDecorator(character));
        enemy = new WarriorDecorator(new OrcDecorator(enemy));

        BattleUI battle = new BattleUI(new Battle(character, enemy));
        battle.startBattle();
    }
}