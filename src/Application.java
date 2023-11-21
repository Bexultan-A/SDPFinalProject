import battle.Battle;
import battle.BattleController;
import characterCreation.CharacterCreationManager;
import characterCreation.CharacterFactory;
import characterCreation.EnemyCreator;
import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;
import data.interfaces.IDB;
import repositories.TowerRepository;
import repositories.interfaces.ITowerRepository;
import tower.Tower;

import java.util.Scanner;

public class Application {
    Scanner scanner;
    Tower tower;
    ITowerRepository repository;
    ICharacterFactory factory;
    public Application(IDB db) {
        this.scanner = new Scanner(System.in);
        this.repository = new TowerRepository(db);
        this.factory = new CharacterFactory();
    }

    public void startGame() {
        System.out.println("""
                Hello, do you wanna start a New Game or Continue Previous Game?:
                 1. New Game
                 2. Continue Previous
                 3. Exit""");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> NewGame();
            case 2 -> ContinueGame();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("ERROR: NO SUCH OPTION!");
                startGame();
            }
        }

        startBattle();
    }

    public void startBattle() {
        EnemyCreator enemyCreator = new EnemyCreator(factory);
        Battle battle = new Battle(tower.getCharacter(), enemyCreator.createEnemy());
        BattleController battleController = new BattleController(battle);


        while (true) {
            boolean win = battleController.startBattle();
            if (!win) {
                defeat();
            }
            tower.nextLevel();
            endOfBattle(enemyCreator,battle,battleController);
        }
    }

    private void endOfBattle(EnemyCreator enemyCreator, Battle battle, BattleController battleController) {
        System.out.println("""
                    Do you want to continue to play?:
                     1. Yes, continue
                     2. No, save my progress and quit""");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> {
                ICharacter newEnemy = enemyCreator.createEnemy();
                battle = new Battle(tower.getCharacter(), newEnemy);
                battleController = new BattleController(battle);
            }
            case 2 -> {
                SaveGame();
                EndGame();
            }
            default -> {
                System.out.println("Error: No such option!!!");
                endOfBattle(enemyCreator,battle,battleController);
            }
        }
    }


    public void NewGame() {
        CharacterCreationManager characterCreationManager = new CharacterCreationManager(factory);
        ICharacter character = characterCreationManager.createCharacter();

        tower = new Tower(1,character);
    }

    public void ContinueGame() {
        repository.showEverything();
        System.out.println("Enter the id of tower you want to continue: ");
        try {
            int id = scanner.nextInt();
            ICharacter character = repository.getCharacter(id);
            if (character == null) {
                System.out.println("ERROR, id is out of range, try again!");
                scanner.nextLine();
                startGame();
            }
            int level = repository.getTowerLevel(id);

            tower = new Tower(level,character);
        } catch (Exception e) {
            System.out.println("ERROR, try again!!");
            scanner.nextLine();
            startGame();
        }
    }

    public void SaveGame() {
        repository.saveProgress(tower);
    }

    public void EndGame() {
        System.exit(0);
    }

    public void defeat() {
        System.out.println("GAME OVER");
        System.out.println();
        System.out.println("""
                Wanna start new game?:
                 1. Yes
                 2. No""");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> NewGame();
            case 2 -> EndGame();
            default -> {
                System.out.println("Error: No such option!!!");
                defeat();
            }
        }
    }
}
