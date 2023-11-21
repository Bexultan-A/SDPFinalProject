package repositories;

import characterCreation.CharacterFactory;
import characterCreation.interfaces.ICharacterFactory;
import characters.interfaces.ICharacter;
import data.PostgresqlDB;
import data.interfaces.IDB;
import repositories.interfaces.ITowerRepository;
import tower.Tower;

import java.sql.*;
import java.sql.SQLException;

public class TowerRepository implements ITowerRepository {
    private final IDB db;

    public TowerRepository(IDB db) {
        this.db = db;
    }

    @Override
    public void showEverything() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM towers";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println( "id: " +
                        rs.getInt("id") + " lvl: " +
                        rs.getInt("level") + " race: " +
                        rs.getString("race") + " class: " +
                        rs.getString("class") + " name: " +
                        rs.getString("name") + " hp: " +
                        rs.getDouble("hp") + " armor: " +
                        rs.getDouble("armor") + " strength: " +
                        rs.getDouble("strength") + " agility: " +
                        rs.getDouble("agility") + " intellect: " +
                        rs.getDouble("intellect"));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public String saveProgress(Tower tower) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO towers(level,name,race,class,hp,armor,strength,agility,intellect) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, tower.getLevel());
            st.setString(2, tower.getCharacter().getName());
            st.setString(3, getRace(tower.getCharacter()));
            st.setString(4, getClass(tower.getCharacter()));
            st.setDouble(5,tower.getCharacter().getHP());
            st.setDouble(6,tower.getCharacter().getArmor());
            st.setDouble(7,tower.getCharacter().getStrength());
            st.setDouble(8,tower.getCharacter().getAgility());
            st.setDouble(9,tower.getCharacter().getIntellect());

            st.execute();
            return "Progress successfully saved!!!";
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "Error: progress save failed!!!";
    }

    @Override
    public int getTowerLevel(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT level FROM towers WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return rs.getInt("level");
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public ICharacter getCharacter(int id) {
        Connection con = null;
        ICharacterFactory factory = new CharacterFactory();
        try {
            con = db.getConnection();
            String sql = "SELECT name,race,class,hp,armor,strength,agility,intellect FROM towers WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

           while (rs.next()) {
               ICharacter character = factory.createCharacter(
                       rs.getString("name"),
                       rs.getDouble("hp"),
                       rs.getDouble("armor"),
                       rs.getDouble("strength"),
                       rs.getDouble("agility"),
                       rs.getDouble("intellect")
               );
               character = factory.decorator(rs.getString("race"), character);
               character = factory.decorator(rs.getString("class"), character);
               return character;
           }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    String getRace(ICharacter character) {
        if (character.getDescription().contains("Elf")) {
            return "elf";
        } else if (character.getDescription().contains("Orc")) {
            return "orc";
        } else {
            return "goblin";
        }
    }

    String getClass(ICharacter character) {
        if (character.getDescription().contains("mage")) {
            return "mage";
        } else if (character.getDescription().contains("warrior")) {
            return "warrior";
        } else {
            return "rogue";
        }
    }
}
