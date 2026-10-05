package com.mycompany.fittrackapps;

import java.util.Scanner;

public class FitTrackApps {

    // Kapasitas maksimum array
    private static final int KAPASITAS = 10;

    // ==================================================
    // METHOD OVERLOADING 1
    // PENCARIAN BERDASARKAN NAMA
    // ==================================================
    private static void cariLatihan(
            Latihan[] data,
            int jumlah,
            String nama) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlah; i++) {

            if (data[i].getNama().equalsIgnoreCase(nama)) {

                System.out.println("\nData ditemukan:");

                data[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Latihan dengan nama \""
                    + nama
                    + "\" tidak ditemukan."
            );
        }
    }

    // ==================================================
    // METHOD OVERLOADING 2
    // PENCARIAN BERDASARKAN DURASI
    // ==================================================
    private static void cariLatihan(
            Latihan[] data,
            int jumlah,
            int durasi) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlah; i++) {

            if (data[i].getDurasiMenit() == durasi) {

                System.out.println("\nData ditemukan:");

                data[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Tidak ada latihan dengan durasi "
                    + durasi
                    + " menit."
            );
        }
    }

    // ==================================================
    // MENAMPILKAN SEMUA DATA
    // ==================================================
    private static void tampilkanSemua(
            Latihan[] data,
            int jumlah) {

        if (jumlah == 0) {

            System.out.println(
                    "\nBelum ada data latihan."
            );

            return;
        }

        System.out.println(
                "\n========================================================"
        );

        System.out.println(
                "                 DAFTAR LATIHAN"
        );

        System.out.println(
                "========================================================"
        );

        System.out.printf(
                "%-3s | %-18s | %-10s | %-10s%n",
                "No",
                "Nama",
                "Durasi",
                "Intensitas"
        );

        System.out.println(
                "--------------------------------------------------------"
        );

        for (int i = 0; i < jumlah; i++) {

            System.out.printf(
                    "%-3d | ",
                    i + 1
            );

            // Polymorphism + overriding
            data[i].tampilkanInfo();
        }

        System.out.println(
                "--------------------------------------------------------"
        );

        System.out.println(
                "Jumlah data saat ini : "
                + jumlah
        );

        System.out.println(
                "Total objek dibuat   : "
                + Latihan.getTotalLatihan()
        );
    }

    // ==================================================
    // MENAMBAHKAN DATA
    // ==================================================
    private static int tambahData(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        if (jumlah >= KAPASITAS) {

            System.out.println(
                    "\nKapasitas data sudah penuh."
            );

            return jumlah;
        }

        System.out.println(
                "\n========================================================"
        );

        System.out.println(
                "                 TAMBAH DATA LATIHAN"
        );

        System.out.println(
                "========================================================"
        );

        System.out.println(
                "1. Latihan Kekuatan"
        );

        System.out.println(
                "2. Latihan Kardio"
        );

        System.out.print(
                "Pilih tipe latihan: "
        );

        int tipe = input.nextInt();

        input.nextLine();

        // ==============================================
        // IF ELSE
        // ==============================================
        if (tipe != 1 && tipe != 2) {

            System.out.println(
                    "Tipe latihan tidak valid."
            );

            return jumlah;
        }

        System.out.print(
                "Nama latihan: "
        );

        String nama = input.nextLine();

        System.out.print(
                "Durasi latihan (menit): "
        );

        int durasi = input.nextInt();

        System.out.print(
                "Intensitas (1-10): "
        );

        int intensitas = input.nextInt();

        input.nextLine();

        // ==============================================
        // LATIHAN KEKUATAN
        // ==============================================
        if (tipe == 1) {

            System.out.print(
                    "Target otot: "
            );

            String targetOtot =
                    input.nextLine();

            System.out.print(
                    "Beban (kg): "
            );

            double beban =
                    input.nextDouble();

            input.nextLine();

            data[jumlah] =
                    new LatihanKekuatan(
                            nama,
                            durasi,
                            intensitas,
                            targetOtot,
                            beban
                    );

            System.out.println(
                    "\nData latihan kekuatan berhasil ditambahkan."
            );
        }

        // ==============================================
        // LATIHAN KARDIO
        // ==============================================
        else {

            System.out.print(
                    "Jenis kardio: "
            );

            String jenisKardio =
                    input.nextLine();

            System.out.print(
                    "Jarak (km): "
            );

            double jarak =
                    input.nextDouble();

            input.nextLine();

            data[jumlah] =
                    new LatihanKardio(
                            nama,
                            durasi,
                            intensitas,
                            jenisKardio,
                            jarak
                    );

            System.out.println(
                    "\nData latihan kardio berhasil ditambahkan."
            );
        }

        return jumlah + 1;
    }

    // ==================================================
    // MENGHAPUS DATA
    // ==================================================
    private static int hapusData(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        // Tidak ada data
        if (jumlah == 0) {

            System.out.println(
                    "\nTidak ada data yang dapat dihapus."
            );

            return jumlah;
        }

        System.out.println(
                "\n========================================================"
        );

        System.out.println(
                "                    HAPUS DATA"
        );

        System.out.println(
                "========================================================"
        );

        // Menampilkan daftar data
        for (int i = 0; i < jumlah; i++) {

            System.out.printf(
                    "%d. %s%n",
                    i + 1,
                    data[i].getNama()
            );
        }

        System.out.println(
                "--------------------------------------------------------"
        );

        System.out.print(
                "Masukkan nomor data yang ingin dihapus: "
        );

        int nomor = input.nextInt();

        input.nextLine();

        // ==============================================
        // VALIDASI NOMOR
        // ==============================================
        if (nomor < 1 || nomor > jumlah) {

            System.out.println(
                    "Nomor data tidak valid."
            );

            return jumlah;
        }

        // Index array dimulai dari 0
        int index = nomor - 1;

        System.out.print(
                "Yakin ingin menghapus \""
                + data[index].getNama()
                + "\"? (y/n): "
        );

        String konfirmasi =
                input.nextLine();

        // ==============================================
        // IF ELSE
        // ==============================================
        if (konfirmasi.equalsIgnoreCase("y")) {

            String namaDihapus =
                    data[index].getNama();

            // ==========================================
            // MENGGESER DATA KE KIRI
            // ==========================================
            for (int i = index; i < jumlah - 1; i++) {

                data[i] = data[i + 1];
            }

            // Mengosongkan posisi terakhir
            data[jumlah - 1] = null;

            jumlah--;

            System.out.println(
                    "\nData latihan \""
                    + namaDihapus
                    + "\" berhasil dihapus."
            );

        } else {

            System.out.println(
                    "\nPenghapusan dibatalkan."
            );
        }

        return jumlah;
    }

    // ==================================================
    // MENU PENCARIAN / AKSI KHUSUS
    // ==================================================
    private static void menuPencarian(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        if (jumlah == 0) {

            System.out.println(
                    "\nBelum ada data latihan."
            );

            return;
        }

        System.out.println(
                "\n========================================================"
        );

        System.out.println(
                "             PENCARIAN / AKSI KHUSUS"
        );

        System.out.println(
                "========================================================"
        );

        System.out.println(
                "1. Cari berdasarkan nama"
        );

        System.out.println(
                "2. Cari berdasarkan durasi"
        );

        System.out.println(
                "3. Tampilkan aksi khusus semua latihan"
        );

        System.out.print(
                "Pilih: "
        );

        int pilihan =
                input.nextInt();

        input.nextLine();

        // ==============================================
        // SWITCH CASE
        // ==============================================
        switch (pilihan) {

            case 1:

                System.out.print(
                        "Masukkan nama latihan: "
                );

                String nama =
                        input.nextLine();

                // Method overloading String
                cariLatihan(
                        data,
                        jumlah,
                        nama
                );

                break;

            case 2:

                System.out.print(
                        "Masukkan durasi latihan: "
                );

                int durasi =
                        input.nextInt();

                input.nextLine();

                // Method overloading int
                cariLatihan(
                        data,
                        jumlah,
                        durasi
                );

                break;

            case 3:

                System.out.println(
                        "\n--- AKSI KHUSUS ---"
                );

                for (int i = 0; i < jumlah; i++) {

                    System.out.println(
                            "\n"
                            + (i + 1)
                            + ". "
                            + data[i].getNama()
                    );

                    // Method overriding
                    data[i].aksiKhusus();
                }

                break;

            default:

                System.out.println(
                        "Pilihan tidak tersedia."
                );
        }
    }

    // ==================================================
    // MAIN
    // ==================================================
    public static void main(String[] args) {

        Scanner input =
                new Scanner(System.in);

        // ==============================================
        // ARRAY
        // ==============================================
        Latihan[] data =
                new Latihan[KAPASITAS];

        // ==============================================
        // 4 OBJECT AWAL
        // ==============================================

        data[0] =
                new LatihanKekuatan(
                        "Bench Press",
                        45,
                        8,
                        "Dada",
                        40
                );

        data[1] =
                new LatihanKardio(
                        "Lari Pagi",
                        30,
                        6,
                        "Running",
                        4.5
                );

        data[2] =
                new LatihanKekuatan(
                        "Squat",
                        40,
                        9,
                        "Kaki",
                        50
                );

        data[3] =
                new LatihanKardio(
                        "Bersepeda",
                        60,
                        7,
                        "Cycling",
                        12
                );

        int jumlah = 4;

        int pilihan;

        // ==============================================
        // DO-WHILE
        // Program terus berjalan sampai pilih 5
        // ==============================================
        do {

            System.out.println(
                    "\n========================================================"
            );

            System.out.println(
                    "              FITTRACK - DATA LATIHAN"
            );

            System.out.println(
                    "========================================================"
            );

            System.out.println(
                    "1. Tambah Data Baru"
            );

            System.out.println(
                    "2. Tampilkan Seluruh Data"
            );

            System.out.println(
                    "3. Pencarian / Aksi Khusus"
            );

            System.out.println(
                    "4. Hapus Data"
            );

            System.out.println(
                    "5. Keluar"
            );

            System.out.println(
                    "========================================================"
            );

            System.out.print(
                    "Pilih menu: "
            );

            pilihan =
                    input.nextInt();

            input.nextLine();

            // ==========================================
            // SWITCH MENU UTAMA
            // ==========================================
            switch (pilihan) {

                case 1:

                    jumlah =
                            tambahData(
                                    input,
                                    data,
                                    jumlah
                            );

                    break;

                case 2:

                    tampilkanSemua(
                            data,
                            jumlah
                    );

                    break;

                case 3:

                    menuPencarian(
                            input,
                            data,
                            jumlah
                    );

                    break;

                case 4:

                    jumlah =
                            hapusData(
                                    input,
                                    data,
                                    jumlah
                            );

                    break;

                case 5:

                    System.out.println(
                            "\n=============================================="
                    );

                    System.out.println(
                            "Terima kasih telah menggunakan FITTRACK!"
                    );

                    System.out.println(
                            "Program selesai."
                    );

                    System.out.println(
                            "=============================================="
                    );

                    break;

                default:

                    System.out.println(
                            "\nPilihan menu tidak valid!"
                    );
            }

        } while (pilihan != 5);

        input.close();
    }
}