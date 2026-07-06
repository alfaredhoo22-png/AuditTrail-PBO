package dao;

import config.DatabaseConfig;
import model.LogEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuditTrailDAO {

    public void simpanLogKeDatabase(LogEntry log) {

        String sql = "INSERT INTO tb_audit_trail (...) VALUES (...)";

        try (Connection conn = DatabaseConfig.getConnection()) {

            // kode

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}