package tower;

import characters.interfaces.IAdventurer;
import tower.interfaces.ITowerEvent;

import java.util.ArrayList;

public class TowerEventManager implements ITowerEvent {
    private final ArrayList<IAdventurer> adventurers;

    public TowerEventManager() {
        this.adventurers = new ArrayList<>();
    }

    @Override
    public void addAdventurer(IAdventurer adventurer) {
        adventurers.add(adventurer);
    }

    @Override
    public void removeAdventurer(IAdventurer adventurer) {
        adventurers.remove(adventurer);
    }

    @Override
    public void notifyAdventurers() {
        for (IAdventurer adventurer : adventurers) {
            adventurer.update();
        }
    }
}
