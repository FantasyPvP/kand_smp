package fantasypvp.kand.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// import sql database library and connect


public class Database {

    public class SQLite {
        private static Connection connection;
        private static SQLite instance;

        private SQLite() {
            connect();
        }

        public static Connection connect() {
            try {
                String url = "jdbc:sqlite:database.db";
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void disconnect() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public SQLite getInstance() {
            if (instance == null) {
                instance = new SQLite();
            }
            return instance;
        }
    }
}