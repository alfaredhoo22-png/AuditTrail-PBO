package view ;

import util.GlobalLogger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AuditTrailGUI extends JFrame {
    private JTextArea logStreamArea;

    public AuditTrailGUI() {
        setTitle("Forensic Audit Trail & System Log Monitoring");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblHeader = new JLabel(" SENTRALISASI LOG FORENSIK APLIKASI", SwingConstants.LEFT);
        lblHeader.setFont(new Font("Monospaced", Font.BOLD, 18));
        lblHeader.setOpaque(true);
        lblHeader.setBackground(Color.DARK_GRAY);
        lblHeader.setForeground(Color.GREEN);
        add(lblHeader, BorderLayout.NORTH);

        logStreamArea = new JTextArea();
        logStreamArea.setEditable(false);
        logStreamArea.setBackground(Color.BLACK);
        logStreamArea.setForeground(Color.GREEN);
        logStreamArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(logStreamArea);
        add(scrollPane, BorderLayout.CENTER);

        GlobalLogger.getInstance().setJTextAreaStream(logStreamArea);

        JPanel panelSimulasi = new JPanel();
        JButton btnLogin = new JButton("Simulasi: User Login");
        JButton btnHapusData = new JButton("Simulasi: Hapus Data");
        JButton btnError = new JButton("Simulasi: Gagal Koneksi");

        panelSimulasi.add(btnLogin);
        panelSimulasi.add(btnHapusData);
        panelSimulasi.add(btnError);
        add(panelSimulasi, BorderLayout.SOUTH);

        btnLogin.addActionListener((ActionEvent e) -> {
            GlobalLogger.getInstance().catatLog("INFO", "User_Alpha", "Berhasil login ke sistem");
        });

        btnHapusData.addActionListener((ActionEvent e) -> {
            GlobalLogger.getInstance().catatLog("WARNING", "User_Alpha", "Melakukan aksi penghapusan rekaman sistem");
        });

        btnError.addActionListener((ActionEvent e) -> {
            GlobalLogger.getInstance().catatLog("SEVERE", "System", "Kehilangan paket ping ke server pusat selama 500ms");
        });
    }
}
