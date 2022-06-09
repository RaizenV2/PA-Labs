package homework.DAO;

import java.sql.SQLException;

public interface DAOInterface {
    void create(String string, int integer) throws SQLException;

    Integer findByName(String string) throws SQLException;

    String findById(Integer integer) throws SQLException;
}
