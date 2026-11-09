
package com.mycompany.fittracks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FitTrack {

    // COMPOSITION
    private DashboardFitTrack dashboard;

    // AGGREGATION
    private ArrayList<Latihan> daftarLatihan;
    private HashMap<String, Pengguna> dataPengguna;

    public FitTrack() {

        // Objek Dashboard dibuat di dalam constructor
        dashboard = new DashboardFitTrack();

        // Menyiapkan tempat penyimpanan data
        daftarLatihan = new ArrayList<>();
        dataPengguna = new HashMap<>();
    }

    // ==============================
    // PENGELOLAAN LATIHAN
    // ==============================

    public void tambahLatihan(Latihan latihan) {
        if (latihan == null) {
            throw new IllegalArgumentException(
                    "Data latihan tidak boleh kosong.");
        }

        daftarLatihan.add(latihan);

        System.out.println(
                "Latihan berhasil ditambahkan.");
    }

    public void tampilkanSemuaLatihan() {

        if (daftarLatihan.isEmpty()) {
            System.out.println("Belum ada latihan.");
            return;
        }

        System.out.println("\n===== DAFTAR LATIHAN =====");

        for (int i = 0; i < daftarLatihan.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            daftarLatihan.get(i).tampilkanInfo();
        }
    }

    public Latihan cariLatihan(String nama)
            throws LatihanTidakDitemukanException {

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama latihan tidak boleh kosong.");
        }

        for (Latihan latihan : daftarLatihan) {
            if (latihan.getNama().equalsIgnoreCase(
                    nama.trim())) {
                return latihan;
            }
        }

        throw new LatihanTidakDitemukanException(
                "Latihan " + nama + " tidak ditemukan.");
    }

    public void hapusLatihan(String nama)
            throws LatihanTidakDitemukanException {

        Latihan latihan = cariLatihan(nama);

        daftarLatihan.remove(latihan);

        System.out.println(
                "Latihan berhasil dihapus.");
    }

    public Latihan getLatihan(int index) {

        if (index < 0 || index >= daftarLatihan.size()) {
            throw new IllegalArgumentException(
                    "Nomor latihan tidak valid.");
        }

        return daftarLatihan.get(index);
    }

    public int getJumlahLatihan() {
        return daftarLatihan.size();
    }

    // ==============================
    // PENGELOLAAN PENGGUNA
    // ==============================

    public void tambahPengguna(Pengguna pengguna) {

        if (pengguna == null) {
            throw new IllegalArgumentException(
                    "Data pengguna tidak boleh kosong.");
        }

        String id = pengguna.getId();

        if (dataPengguna.containsKey(id)) {
            throw new IllegalArgumentException(
                    "ID pengguna sudah terdaftar.");
        }

        dataPengguna.put(id, pengguna);

        System.out.println(
                "Pengguna berhasil ditambahkan.");
    }

    public Pengguna cariPengguna(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID pengguna tidak boleh kosong.");
        }

        Pengguna pengguna = dataPengguna.get(id.trim());

        if (pengguna == null) {
            throw new IllegalArgumentException(
                    "Pengguna tidak ditemukan.");
        }

        return pengguna;
    }

    public void tampilkanSemuaPengguna() {

        System.out.println("\n===== DAFTAR PENGGUNA =====");

        if (dataPengguna.isEmpty()) {
            System.out.println("Belum ada pengguna.");
            return;
        }

        for (Map.Entry<String, Pengguna> data
                : dataPengguna.entrySet()) {

            System.out.println("\nID: " + data.getKey());
            System.out.println(
                    "Nama: " + data.getValue().getNama());
        }

        System.out.println(
                "Total pengguna: " + dataPengguna.size());
    }

    public int getJumlahPengguna() {
        return dataPengguna.size();
    }

    // ==============================
    // COMPOSITION
    // ==============================

    public void tampilkanDashboard() {

        dashboard.tampilkanDashboard(
                daftarLatihan.size(),
                dataPengguna.size());
    }
}
