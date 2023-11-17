package repositories.interfaces;

import characters.interfaces.ICharacter;
import tower.Tower;


public interface ITowerRepository {
    String saveProgress(Tower tower);
    ICharacter getCharacter(int id);
    int getTowerLevel(int id);
    void showEverything();
}
