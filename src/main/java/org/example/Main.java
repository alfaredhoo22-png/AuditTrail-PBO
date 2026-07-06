import view.AuditTrailGUI;
import util.GlobalLogger;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Membuktikan perlindungan instansiasi ganda
        GlobalLogger logger1 = GlobalLogger.getInstance();
        GlobalLogger logger2 = GlobalLogger.getInstance();
        if (logger1 == logger2) {
            System.out.println("TEST SINGLETON BERHASIL: Logger1 dan Logger2 mengarah pada memori yang sama persis.");
        }

        SwingUtilities.invokeLater(() -> {
            AuditTrailGUI frame = new AuditTrailGUI();
            frame.setVisible(true);
            GlobalLogger.getInstance().catatLog("SYSTEM_START", "Root_Admin", "GUI Monitoring Forensik mulai berjalan.");
        });
    }
}
