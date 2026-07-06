package util;

import dao.AuditTrailDAO;
import model.LogEntry;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.sql.Timestamp;

public class GlobalLogger {
    // 1. Keyword 'volatile' adalah kunci Double-Checked Locking di Java!
    private static volatile GlobalLogger instance;

    private AuditTrailDAO dao;
    private JTextArea streamArea;

    // 2. Private Constructor
    private GlobalLogger() {
        this.dao = new AuditTrailDAO();
    }

    // 3. Method getInstance() dengan Double-Checked Locking
    public static GlobalLogger getInstance() {
        if (instance == null) {
            synchronized (GlobalLogger.class) {
                if (instance == null) {
                    instance = new GlobalLogger();
                }
            }
        }
        return instance;
    }

    public void setJTextAreaStream(JTextArea area) {
        this.streamArea = area;
    }

    public void catatLog(String level, String aktor, String aktivitas) {
        Timestamp waktu = new Timestamp(System.currentTimeMillis());
        LogEntry logBaru = new LogEntry(level, aktor, aktivitas, waktu);

        if (streamArea != null) {
            String formatPesan = String.format("[%s] [%s] %s: %s\n", waktu, level, aktor, aktivitas);
            SwingUtilities.invokeLater(() -> {
                streamArea.append(formatPesan);
                streamArea.setCaretPosition(streamArea.getDocument().getLength());
            });
        }

        System.out.printf("[%s] [%s] %s: %s\n", waktu, level, aktor, aktivitas);
        new Thread(() -> dao.simpanLogKeDatabase(logBaru)).start();
    }
}
