package com.mycompany.fittracks;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransaksiFitTrack {

    public void catatLatihan(
            Pengguna pengguna, Latihan latihan) {

        if (pengguna == null || latihan == null) {
            throw new IllegalArgumentException(
                    "Pengguna dan latihan harus tersedia.");
        }

        String waktu = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"));

        String log =
                "================================\n"
                + "Waktu         : " + waktu + "\n"
                + "Nama pengguna : " + pengguna.getNama() + "\n"
                + "ID pengguna   : " + pengguna.getId() + "\n"
                + "Nama latihan  : " + latihan.getNama() + "\n"
                + "Durasi        : " + latihan.getDurasiMenit()
                + " menit\n"
                + "Intensitas    : " + latihan.getIntensitas()
                + "\n"
                + "Status        : BERHASIL DICATAT\n"
                + "================================\n\n";

        System.out.println("\n===== TRANSAKSI LATIHAN =====");
        System.out.println("Nama pengguna : " + pengguna.getNama());
        System.out.println("ID pengguna   : " + pengguna.getId());
        System.out.println("Nama latihan  : " + latihan.getNama());
        System.out.println("Durasi        : "
                + latihan.getDurasiMenit() + " menit");
        System.out.println("Intensitas    : " + latihan.getIntensitas());
        System.out.println("Waktu         : " + waktu);
        System.out.println("Status        : BERHASIL DICATAT");

        FileWriter penulis = null;

        try {
            penulis = new FileWriter("log_aktivitas.txt", true);
            penulis.write(log);

            System.out.println(
                    "Log berhasil disimpan ke file.");

        } catch (IOException e) {

            System.out.println(
                    "Gagal menulis log: " + e.getMessage());

        } finally {

            try {
                if (penulis != null) {
                    penulis.close();
                }
            } catch (IOException e) {
                System.out.println(
                        "Gagal menutup file: " + e.getMessage());
            }
        }

        System.out.println("=============================");
    }
}