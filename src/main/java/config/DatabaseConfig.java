package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Masukkan URL dari Supabase kalian
    // Konfigurasi Database PostgreSQL melalui Supabase (Shared Pooler)
    private static final String URL = "jdbc:postgresql://aws-1-ap-southeast-1.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.grmewrzgjwjiauiimxuz";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
