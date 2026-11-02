package com.mycompany.fittracks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FITTRACKS {

    private static final Scanner input = new Scanner(System.in);

    // ArrayList untuk menyimpan objek latihan.
    private static final ArrayList<Latihan> daftarLatihan
            = new ArrayList<>();

    // HashMap untuk menyimpan ID dan nama anggota.
    private static final HashMap<String, String> dataAnggota
            = new HashMap<>();

    public static void main(String[] args) {

        isiDataAwal();
        isiAnggotaAwal();

        boolean berjalan = true;

        try {
            while (berjalan) {
                tampilkanMenu();

                try {
                    System.out.print("Pilih menu: ");
                    int pilihan = input.nextInt();
                    input.nextLine();

                    switch (pilihan) {
                        case 1:
                            tambahLatihan();
                            break;

                        case 2:
                            tampilkanSemuaLatihan();
                            break;

                        case 3:
                            cariLatihanMenu();
                            break;

                        case 4:
                            simulasiDynamicBinding();
                            break;

                        case 5:
                            hapusLatihan();
                            break;

                        case 6:
                            menuAnggota();
                            break;

                        case 0:
                            berjalan = false;
                            break;

                        default:
                            System.out.println(
                                    "Pilihan menu tidak tersedia.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println(
                            "Error: Input harus berupa angka.");
                    input.nextLine();

                } catch (LatihanTidakDitemukanException e) {
                    System.out.println(
                            "Error: " + e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Error validasi: " + e.getMessage());

                } finally {
                    System.out.println(
                            "[INFO] Proses menu selesai.");
                }
            }

        } finally {
            input.close();
            System.out.println(
                    "FitTrack ditutup. Terima kasih.");
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n========== FITTRACK ==========");
        System.out.println("1. Tambah data latihan");
        System.out.println("2. Tampilkan seluruh latihan");
        System.out.println("3. Cari latihan berdasarkan nama");
        System.out.println("4. Simulasi dynamic binding");
        System.out.println("5. Hapus latihan berdasarkan nama");
        System.out.println("6. Kelola anggota (HashMap)");
        System.out.println("0. Keluar");
        System.out.println(
                "Jumlah latihan: " + daftarLatihan.size());
        System.out.println("==============================");
    }

    private static void isiDataAwal() {
        daftarLatihan.add(
                new LatihanKekuatan(
                        "Bench Press", 30, "Tinggi", "Dada", 40));

        daftarLatihan.add(
                new LatihanKardio(
                        "Lari Pagi", 25, "Sedang", "Lari", 3.0));

        daftarLatihan.add(
                new LatihanFleksibilitas(
                        "Yoga", 20, "Rendah", "Yoga", 8));

        daftarLatihan.add(
                new LatihanKekuatan(
                        "Squat", 20, "Sedang", "Kaki", 25));

        daftarLatihan.add(
                new LatihanKardio(
                        "Bersepeda", 45, "Sedang", "Sepeda", 10.5));
    }

    private static void isiAnggotaAwal() {
        dataAnggota.put("FT001", "Irfan Ahmad");
        dataAnggota.put("FT002", "Nadia Putri");
        dataAnggota.put("FT003", "Rian Saputra");
    }

    // MENU 1: TAMBAH LATIHAN
    private static void tambahLatihan() {

        System.out.println("\nJenis latihan:");
        System.out.println("1. Kekuatan");
        System.out.println("2. Kardio");
        System.out.println("3. Fleksibilitas");

        System.out.print("Pilih jenis: ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Nama latihan: ");
        String nama = input.nextLine();

        System.out.print("Durasi (menit): ");
        int durasi = input.nextInt();
        input.nextLine();

        System.out.print("Intensitas: ");
        String intensitas = input.nextLine();

        Latihan latihan;

        switch (jenis) {
            case 1:
                System.out.print("Target otot: ");
                String target = input.nextLine();

                System.out.print("Beban (kg): ");
                double beban = input.nextDouble();
                input.nextLine();

                latihan = new LatihanKekuatan(
                        nama, durasi, intensitas, target, beban);
                break;

            case 2:
                System.out.print("Jenis kardio: ");
                String tipe = input.nextLine();

                System.out.print("Jarak (km): ");
                double jarak = input.nextDouble();
                input.nextLine();

                latihan = new LatihanKardio(
                        nama, durasi, intensitas, tipe, jarak);
                break;

            case 3:
                System.out.print("Jenis peregangan: ");
                String peregangan = input.nextLine();

                System.out.print("Jumlah gerakan: ");
                int gerakan = input.nextInt();
                input.nextLine();

                latihan = new LatihanFleksibilitas(
                        nama, durasi, intensitas,
                        peregangan, gerakan);
                break;

            default:
                throw new IllegalArgumentException(
                        "Jenis latihan harus 1, 2, atau 3.");
        }

        daftarLatihan.add(latihan);

        System.out.println(
                "Latihan berhasil ditambahkan.");
    }

    // MENU 2: TAMPILKAN LATIHAN
    private static void tampilkanSemuaLatihan() {

        if (daftarLatihan.isEmpty()) {
            System.out.println("Belum ada data latihan.");
            return;
        }

        System.out.println("\n===== DAFTAR LATIHAN =====");

        for (int i = 0; i < daftarLatihan.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            daftarLatihan.get(i).tampilkanInfo();
        }
    }

    // PENCARIAN DENGAN CUSTOM EXCEPTION
    private static Latihan cariLatihan(String nama)
            throws LatihanTidakDitemukanException {

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama pencarian tidak boleh kosong.");
        }

        for (Latihan latihan : daftarLatihan) {
            if (latihan.getNama()
                    .equalsIgnoreCase(nama.trim())) {
                return latihan;
            }
        }

        throw new LatihanTidakDitemukanException(
                "Latihan '" + nama + "' tidak ditemukan.");
    }

    // MENU 3: CARI LATIHAN
    private static void cariLatihanMenu()
            throws LatihanTidakDitemukanException {

        System.out.print("Masukkan nama latihan: ");
        String nama = input.nextLine();

        Latihan hasil = cariLatihan(nama);

        System.out.println("Data ditemukan:");
        hasil.tampilkanInfo();
    }

    // MENU 4: DYNAMIC BINDING
    private static void simulasiDynamicBinding()
            throws LatihanTidakDitemukanException {

        System.out.print("Nama latihan: ");
        String nama = input.nextLine();

        Latihan hasil = cariLatihan(nama);

        hasil.aksiKhusus();
    }

    // MENU 5: HAPUS LATIHAN
    private static void hapusLatihan()
            throws LatihanTidakDitemukanException {

        System.out.print("Nama latihan yang dihapus: ");
        String nama = input.nextLine();

        Latihan hasil = cariLatihan(nama);

        daftarLatihan.remove(hasil);

        System.out.println(
                "Latihan berhasil dihapus.");
    }

    // MENU 6: PENGELOLAAN HASHMAP
    private static void menuAnggota() {

        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n===== KELOLA ANGGOTA =====");
            System.out.println("1. Tambah anggota");
            System.out.println("2. Cari anggota");
            System.out.println("3. Tampilkan semua anggota");
            System.out.println("0. Kembali");

            try {
                System.out.print("Pilih menu anggota: ");
                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahAnggota();
                        break;

                    case 2:
                        cariAnggota();
                        break;

                    case 3:
                        tampilkanAnggota();
                        break;

                    case 0:
                        kembali = true;
                        break;

                    default:
                        System.out.println(
                                "Pilihan tidak tersedia.");
                }

            } catch (InputMismatchException e) {
                System.out.println(
                        "Error: Pilihan harus berupa angka.");
                input.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Error validasi: " + e.getMessage());

            } finally {
                System.out.println(
                        "[INFO] Operasi anggota selesai.");
            }
        }
    }

    // TAMBAH ANGGOTA
    private static void tambahAnggota() {

        System.out.print("ID anggota: ");
        String id = input.nextLine().trim();

        System.out.print("Nama anggota: ");
        String nama = input.nextLine().trim();

        if (id.isEmpty() || nama.isEmpty()) {
            throw new IllegalArgumentException(
                    "ID dan nama tidak boleh kosong.");
        }

        if (dataAnggota.containsKey(id)) {
            throw new IllegalArgumentException(
                    "ID anggota sudah terdaftar.");
        }

        dataAnggota.put(id, nama);

        System.out.println(
                "Anggota berhasil ditambahkan.");
    }

    // CARI ANGGOTA
    private static void cariAnggota() {

        System.out.print("Masukkan ID anggota: ");
        String id = input.nextLine().trim();

        if (id.isEmpty()) {
            throw new IllegalArgumentException(
                    "ID tidak boleh kosong.");
        }

        if (dataAnggota.containsKey(id)) {
            System.out.println(
                    "Anggota ditemukan: "
                    + dataAnggota.get(id));
        } else {
            System.out.println(
                    "Anggota dengan ID " + id
                    + " tidak ditemukan.");
        }
    }

    // TAMPILKAN SEMUA ANGGOTA
    private static void tampilkanAnggota() {

        System.out.println(
                "Jumlah anggota: " + dataAnggota.size());

        if (dataAnggota.isEmpty()) {
            System.out.println("Belum ada anggota.");
            return;
        }

        for (Map.Entry<String, String> anggota
                : dataAnggota.entrySet()) {

            System.out.println(
                    "ID: " + anggota.getKey()
                    + " | Nama: " + anggota.getValue());
        }
    }
}