package tower.interfaces;

import characters.interfaces.IAdventurer;

public interface ITowerEvent {
    void addAdventurer(IAdventurer adventurer);
    void removeAdventurer(IAdventurer adventurer);
    void notifyAdventurers();
}
