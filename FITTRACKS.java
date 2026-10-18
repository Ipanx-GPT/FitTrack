package com.mycompany.fittracks;

import java.util.Scanner;

public class FITTRACKS {

    private static final Scanner input = new Scanner(System.in);
    private static final Latihan[] data = new Latihan[10];
    private static int jumlah = 0;

    public static void main(String[] args) {
        isiDataAwal();

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tampilkanSemua();
                    break;

                case 2:
                    jalankanAksi();
                    break;

                case 3:
                    cariLatihan();
                    break;

                case 4:
                    tambahLatihan();
                    break;

                case 5:
                    hapusLatihan();
                    break;

                case 6:
                    System.out.println(
                        "Terima kasih telah menggunakan FitTrack!"
                    );
                    break;

                default:
                    System.out.println(
                        "Pilihan tidak valid. Silakan pilih 1-6."
                    );
            }

        } while (pilihan != 6);

        input.close();
    }

    // Membuat lima objek awal dari berbagai subclass.
    private static void isiDataAwal() {
        data[jumlah++] = new LatihanKekuatan(
            "Bench Press", 30, "Sedang", "dada", 20
        );

        data[jumlah++] = new LatihanKardio(
            "Lari Pagi", 25, "Sedang", "lari", 3.5
        );

        data[jumlah++] = new LatihanFleksibilitas(
            "Yoga", 20, "Ringan", "seluruh tubuh", 8
        );

        data[jumlah++] = new LatihanKekuatan(
            "Squat", 25, "Tinggi", "kaki", 30
        );

        data[jumlah++] = new LatihanKardio(
            "Bersepeda", 40, "Sedang", "sepeda", 8.0
        );
    }

    // Menampilkan menu utama.
    private static void tampilkanMenu() {
        System.out.println("\n================================");
        System.out.println("          FITTRACK");
        System.out.println("     Manajemen Aktivitas");
        System.out.println("================================");
        System.out.println("1. Tampilkan semua latihan");
        System.out.println("2. Jalankan aksi latihan");
        System.out.println("3. Cari latihan berdasarkan nama");
        System.out.println("4. Tambah latihan");
        System.out.println("5. Hapus latihan");
        System.out.println("6. Keluar");
        System.out.println("--------------------------------");
    }

    // Menampilkan semua data latihan.
    private static void tampilkanSemua() {
        if (jumlah == 0) {
            System.out.println("Belum ada data latihan.");
            return;
        }

        System.out.println("\n=== DAFTAR LATIHAN FITTRACK ===");

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData ke-" + (i + 1));
            data[i].tampilkanInfo();
            System.out.println("Jenis      : "
                    + jenisLatihan(data[i]));
        }
    }

    // Menentukan jenis subclass menggunakan instanceof.
    private static String jenisLatihan(Latihan latihan) {
        if (latihan instanceof LatihanKekuatan) {
            return "Kekuatan";
        }

        if (latihan instanceof LatihanKardio) {
            return "Kardio";
        }

        if (latihan instanceof LatihanFleksibilitas) {
            return "Fleksibilitas";
        }

        return "Tidak diketahui";
    }

    // Menjalankan abstract method dan method interface.
    private static void jalankanAksi() {
        if (jumlah == 0) {
            System.out.println(
                "Belum ada latihan untuk diproses."
            );
            return;
        }

        tampilkanRingkas();

        int nomor = bacaInt("Pilih nomor latihan: ");

        if (nomor < 1 || nomor > jumlah) {
            System.out.println(
                "Nomor latihan tidak tersedia."
            );
            return;
        }

        Latihan latihan = data[nomor - 1];

        System.out.println("\n=== AKSI LATIHAN: "
                + latihan.getNama() + " ===");

        latihan.aksiKhusus();

        if (latihan instanceof DapatDilacak) {
            ((DapatDilacak) latihan).catatAktivitas();
        } else {
            System.out.println(
                "Latihan ini tidak mendukung pencatatan aktivitas."
            );
        }

        if (latihan instanceof DapatDiberiTarget) {
            ((DapatDiberiTarget) latihan).tampilkanTarget();
        } else {
            System.out.println(
                "Latihan ini tidak memiliki fitur target khusus."
            );
        }
    }

    private static void cariLatihan() {
        System.out.print(
            "Masukkan nama latihan yang dicari: "
        );

        String kataKunci = input.nextLine().trim();
        boolean ditemukan = false;

        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNama().toLowerCase()
                    .contains(kataKunci.toLowerCase())) {

                System.out.println("\nLatihan ditemukan:");
                data[i].tampilkanInfo();

                System.out.println("Jenis: "
                        + jenisLatihan(data[i]));

                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println(
                "Latihan dengan nama tersebut tidak ditemukan."
            );
        }
    }

    // Menambahkan latihan baru.
    private static void tambahLatihan() {
        if (jumlah >= data.length) {
            System.out.println(
                "Penyimpanan penuh. Tidak dapat menambah latihan."
            );
            return;
        }

        System.out.println(
            "Pilih jenis latihan: 1. Kekuatan"
            + "  2. Kardio  3. Fleksibilitas"
        );

        int jenis = bacaInt("Jenis: ");

        if (jenis < 1 || jenis > 3) {
            System.out.println(
                "Jenis latihan tidak valid."
            );
            return;
        }

        System.out.print("Nama latihan: ");
        String nama = input.nextLine().trim();

        int durasi = bacaInt("Durasi (menit): ");

        System.out.print(
            "Intensitas (Ringan/Sedang/Tinggi): "
        );
        String intensitas = input.nextLine().trim();

        if (nama.isEmpty() || durasi <= 0
                || intensitas.isEmpty()) {
            System.out.println(
                "Nama, durasi, dan intensitas harus diisi dengan benar."
            );
            return;
        }

        if (jenis == 1) {
            System.out.print("Target otot: ");
            String target = input.nextLine().trim();

            double beban = bacaDouble("Beban (kg): ");

            data[jumlah++] = new LatihanKekuatan(
                nama, durasi, intensitas, target, beban
            );

        } else if (jenis == 2) {
            System.out.print("Jenis kardio: ");
            String kardio = input.nextLine().trim();

            double jarak = bacaDouble("Jarak (km): ");

            data[jumlah++] = new LatihanKardio(
                nama, durasi, intensitas, kardio, jarak
            );

        } else {
            System.out.print("Jenis peregangan: ");
            String peregangan = input.nextLine().trim();

            int gerakan = bacaInt("Jumlah gerakan: ");

            data[jumlah++] = new LatihanFleksibilitas(
                nama, durasi, intensitas,
                peregangan, gerakan
            );
        }

        System.out.println(
            "Latihan berhasil ditambahkan."
        );
    }

    // Menghapus latihan berdasarkan nomor.
    private static void hapusLatihan() {
        if (jumlah == 0) {
            System.out.println(
                "Tidak ada data latihan untuk dihapus."
            );
            return;
        }

        tampilkanRingkas();

        int nomor = bacaInt(
            "Nomor latihan yang akan dihapus: "
        );

        if (nomor < 1 || nomor > jumlah) {
            System.out.println(
                "Nomor latihan tidak tersedia."
            );
            return;
        }

        String namaDihapus = data[nomor - 1].getNama();

        for (int i = nomor - 1; i < jumlah - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--jumlah] = null;

        System.out.println("Latihan '" + namaDihapus
                + "' berhasil dihapus.");
    }

    // Menampilkan nomor dan nama latihan.
    private static void tampilkanRingkas() {
        System.out.println("\n=== PILIH LATIHAN ===");

        for (int i = 0; i < jumlah; i++) {
            System.out.println(
                (i + 1) + ". " + data[i].getNama()
                + " (" + jenisLatihan(data[i]) + ")"
            );
        }
    }

    // Membaca input bilangan bulat dengan validasi.
    private static int bacaInt(String pesan) {
        while (true) {
            System.out.print(pesan);

            try {
                return Integer.parseInt(
                    input.nextLine().trim()
                );
            } catch (NumberFormatException e) {
                System.out.println(
                    "Masukkan bilangan bulat yang valid."
                );
            }
        }
    }

    // Membaca input desimal dengan validasi.
    private static double bacaDouble(String pesan) {
        while (true) {
            System.out.print(pesan);

            try {
                return Double.parseDouble(
                    input.nextLine().trim().replace(',', '.')
                );
            } catch (NumberFormatException e) {
                System.out.println(
                    "Masukkan angka yang valid (contoh: 3.5)."
                );
            }
        }
    }
}