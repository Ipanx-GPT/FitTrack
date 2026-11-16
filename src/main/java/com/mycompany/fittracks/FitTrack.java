package com.mycompany.fittracks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FitTrack {

    private DashboardFitTrack dashboard;
    private ArrayList<Latihan> daftarLatihan;
    private HashMap<String, Pengguna> dataPengguna;

    public FitTrack() {
        dashboard = new DashboardFitTrack();
        daftarLatihan = new ArrayList<>();
        dataPengguna = new HashMap<>();
    }

    public void tambahLatihan(Latihan latihan) {

        if (latihan == null) {
            throw new IllegalArgumentException(
                    "Data latihan tidak boleh kosong.");
        }

        daftarLatihan.add(latihan);

        System.out.println("Latihan berhasil ditambahkan.");
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

        System.out.println("Latihan berhasil dihapus.");
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

        System.out.println("Pengguna berhasil ditambahkan.");
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

    public void tampilkanDashboard() {
        dashboard.tampilkanDashboard(
                daftarLatihan.size(),
                dataPengguna.size());
    }

    public void simpanDataKeFile() {

        ObjectOutputStream output = null;

        try {

            FileOutputStream file =
                    new FileOutputStream("data_fittrack.dat");

            output = new ObjectOutputStream(file);

            output.writeObject(daftarLatihan);
            output.writeObject(dataPengguna);

            System.out.println(
                    "\n[SUCCESS] Data FITTRACK berhasil disimpan.");

            System.out.println(
                    "Jumlah latihan : " + daftarLatihan.size());

            System.out.println(
                    "Jumlah pengguna: " + dataPengguna.size());

            System.out.println(
                    "File: data_fittrack.dat");

        } catch (IOException e) {

            System.out.println(
                    "[ERROR] Gagal menyimpan data: "
                    + e.getMessage());

        } finally {

            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println(
                        "Gagal menutup file: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean muatDataDariFile() {

        File fileData = new File("data_fittrack.dat");

        if (!fileData.exists()) {
            System.out.println(
                    "[INFO] File data belum tersedia.");
            return false;
        }

        ObjectInputStream input = null;

        try {

            FileInputStream file =
                    new FileInputStream(fileData);

            input = new ObjectInputStream(file);

            daftarLatihan =
                    (ArrayList<Latihan>) input.readObject();

            dataPengguna =
                    (HashMap<String, Pengguna>) input.readObject();

            System.out.println(
                    "\n[SUCCESS] Data berhasil dimuat kembali!");

            System.out.println(
                    "Jumlah latihan : " + daftarLatihan.size());

            System.out.println(
                    "Jumlah pengguna: " + dataPengguna.size());

            return true;

        } catch (IOException | ClassNotFoundException
                | ClassCastException e) {

            System.out.println(
                    "[ERROR] Gagal memuat data: "
                    + e.getMessage());

            return false;

        } finally {

            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.out.println(
                        "Gagal menutup file: " + e.getMessage());
            }
        }
    }

    public void bacaLogTransaksi() {

        File fileLog = new File("log_aktivitas.txt");

        System.out.println("\n===== RIWAYAT AKTIVITAS =====");

        if (!fileLog.exists()) {
            System.out.println(
                    "Belum ada file riwayat aktivitas.");
            return;
        }

        Scanner pembaca = null;

        try {

            pembaca = new Scanner(fileLog);

            while (pembaca.hasNextLine()) {
                String baris = pembaca.nextLine();
                System.out.println(baris);
            }

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Gagal membaca file: " + e.getMessage());

        } finally {

            if (pembaca != null) {
                pembaca.close();
            }
        }

        System.out.println(
                "===== AKHIR RIWAYAT AKTIVITAS =====");
    }
}