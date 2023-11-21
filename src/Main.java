
import data.PostgresqlDB;
import data.interfaces.IDB;


public class Main {
    public static void main(String[] args) {
        IDB db = PostgresqlDB.getInstance();
        Application application = new Application(db);

        application.startGame();
    }
}
