package model;

import java.sql.Timestamp;

public class LogEntry {

    private String level;
    private String aktor;
    private String aktivitas;
    private Timestamp waktu;

    public LogEntry(String level, String aktor, String aktivitas, Timestamp waktu) {
        this.level = level;
        this.aktor = aktor;
        this.aktivitas = aktivitas;
        this.waktu = waktu;
    }

    public String getLevel() {
        return level;
    }

    public String getAktor() {
        return aktor;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public Timestamp getWaktu() {
        return waktu;
    }
}