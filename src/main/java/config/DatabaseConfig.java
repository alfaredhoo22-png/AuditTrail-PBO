package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Masukkan URL dari Supabase kalian
    private static final String URL = "jdbc:postgresql://[HOST_SUPABASE_KALIAN]:5432/[NAMA_DB]";
    private static final String USER = "[USERNAME]";
    private static final String PASSWORD = "[PASSWORD]";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}