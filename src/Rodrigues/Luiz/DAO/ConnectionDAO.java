package Rodrigues.Luiz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/inventory_control?useTimezone=true&serverTimezone=UTC", "root", "LWR507705!lwr");
    }
}
