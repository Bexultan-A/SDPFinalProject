package tower;

import characters.interfaces.ICharacter;
import tower.interfaces.ITowerEvent;

public class Tower {
    int level;
    private final ITowerEvent towerEventManager;
    ICharacter character;

    public Tower(int level, ICharacter character) {
        this.level = level;
        this.character = character;
        this.towerEventManager = new TowerEventManager();
        towerEventManager.addAdventurer(character);
    }

    public void nextLevel() {
        setLevel(getLevel()+1);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        if (getLevel() % 10 == 0) {
            towerEventManager.notifyAdventurers("Congratulations, You've reached " + getLevel() +
                    "th level of the tower, later there will be some rewards");
        } else {
            towerEventManager.notifyAdventurers("Congratulations, You've reached next level of the tower, level: " + getLevel());
        }

    }

    public ICharacter getCharacter() {
        return character;
    }

    public void setCharacter(ICharacter character) {
        this.character = character;
    }
}
