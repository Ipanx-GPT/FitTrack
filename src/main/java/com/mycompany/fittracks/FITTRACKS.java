package com.mycompany.fittracks;

import java.util.Scanner;

public class FITTRACKS {

    private static final int KAPASITAS = 10;

    public static void cariLatihan(
            Latihan[] data,
            int jumlah,
            String nama) {

        boolean ditemukan = false;

        System.out.println(
            "\n=== HASIL PENCARIAN NAMA ==="
        );

        for (int i = 0; i < jumlah; i++) {

            if (data[i].getNama()
                    .equalsIgnoreCase(nama)) {

                data[i].tampilkanInfo();

                ditemukan = true;

                System.out.println(
                    "----------------------------------"
                );
            }
        }

        if (!ditemukan) {

            System.out.println(
                "Data dengan nama \""
                + nama
                + "\" tidak ditemukan."
            );
        }
    }

    public static void cariLatihan(
            Latihan[] data,
            int jumlah,
            int durasi) {

        boolean ditemukan = false;

        System.out.println(
            "\n=== HASIL PENCARIAN DURASI ==="
        );

        for (int i = 0; i < jumlah; i++) {

            if (data[i].getDurasiMenit()
                    == durasi) {

                data[i].tampilkanInfo();

                ditemukan = true;

                System.out.println(
                    "----------------------------------"
                );
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

    public static void prosesLatihan(
            Latihan latihan) {

        System.out.println(
            "\n=== SIMULASI AKSI LATIHAN ==="
        );

        System.out.println(
            "Nama latihan : "
            + latihan.getNama()
        );

        System.out.println(
            "Java menerima objek sebagai tipe "
            + "Latihan (Superclass)."
        );

        System.out.println(
            "Kemudian Dynamic Binding menentukan "
            + "method subclass yang dijalankan."
        );

        System.out.println(
            "\nAksi khusus:"
        );
        latihan.aksiKhusus();
    }

    public static void prosesLatihan(
            Latihan latihan,
            int durasiTambahan) {

        System.out.println(
            "\n=== SIMULASI DENGAN DURASI TAMBAHAN ==="
        );

        System.out.println(
            "Latihan : "
            + latihan.getNama()
        );

        System.out.println(
            "Durasi awal : "
            + latihan.getDurasiMenit()
            + " menit"
        );

        System.out.println(
            "Tambahan durasi : "
            + durasiTambahan
            + " menit"
        );

        System.out.println(
            "Total simulasi : "
            + (latihan.getDurasiMenit()
            + durasiTambahan)
            + " menit"
        );
        latihan.aksiKhusus();
    }

    public static void tampilkanSemua(
            Latihan[] data,
            int jumlah) {

        if (jumlah == 0) {

            System.out.println(
                "\nBelum ada data latihan."
            );

            return;
        }

        System.out.println(
            "\n=================================================="
        );

        System.out.println(
            "              SELURUH DATA FITTRACK"
        );

        System.out.println(
            "=================================================="
        );

        for (int i = 0; i < jumlah; i++) {

            System.out.println(
                "\nData ke-" + (i + 1)
            );

            System.out.println(
                "--------------------------------------------------"
            );

            data[i].tampilkanInfo();

            System.out.println(
                "--------------------------------------------------"
            );
        }

        System.out.println(
            "Jumlah data saat ini : "
            + jumlah
        );

        System.out.println(
            "Total objek dibuat   : "
            + Latihan.getTotalObjek()
        );
    }

    public static int tambahData(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        if (jumlah >= KAPASITAS) {

            System.out.println(
                "Kapasitas data sudah penuh."
            );

            return jumlah;
        }

        System.out.println(
            "\n=== TAMBAH DATA LATIHAN ==="
        );

        System.out.println(
            "1. Latihan Kekuatan"
        );

        System.out.println(
            "2. Latihan Kardio"
        );

        System.out.println(
            "3. Latihan Fleksibilitas"
        );

        System.out.print(
            "Pilih jenis latihan: "
        );

        int pilihan =
            input.nextInt();

        input.nextLine();

        System.out.print(
            "Nama latihan: "
        );

        String nama =
            input.nextLine();

        System.out.print(
            "Durasi (menit): "
        );

        int durasi =
            input.nextInt();

        System.out.print(
            "Intensitas (1-10): "
        );

        int intensitas =
            input.nextInt();

        input.nextLine();

        switch (pilihan) {

            case 1:

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

                // UPCASTING
                data[jumlah] =
                    new LatihanKekuatan(
                        nama,
                        durasi,
                        intensitas,
                        targetOtot,
                        beban
                    );

                break;

            case 2:

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

                break;

            case 3:

                System.out.print(
                    "Jenis peregangan: "
                );

                String jenisPeregangan =
                    input.nextLine();

                System.out.print(
                    "Jumlah gerakan: "
                );

                int jumlahGerakan =
                    input.nextInt();

                input.nextLine();

                data[jumlah] =
                    new LatihanFleksibilitas(
                        nama,
                        durasi,
                        intensitas,
                        jenisPeregangan,
                        jumlahGerakan
                    );

                break;

            default:

                System.out.println(
                    "Jenis latihan tidak valid."
                );

                return jumlah;
        }

        System.out.println(
            "\nData berhasil ditambahkan!"
        );

        return jumlah + 1;
    }

    public static int hapusData(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        if (jumlah == 0) {

            System.out.println(
                "\nTidak ada data untuk dihapus."
            );

            return jumlah;
        }

        System.out.println(
            "\n=== HAPUS DATA ==="
        );

        for (int i = 0; i < jumlah; i++) {

            System.out.println(
                (i + 1)
                + ". "
                + data[i].getNama()
            );
        }

        System.out.print(
            "\nPilih nomor data: "
        );

        int nomor =
            input.nextInt();

        input.nextLine();

        if (nomor < 1 || nomor > jumlah) {

            System.out.println(
                "Nomor tidak valid."
            );

            return jumlah;
        }

        int index =
            nomor - 1;

        System.out.print(
            "Yakin menghapus \""
            + data[index].getNama()
            + "\"? (y/n): "
        );

        String konfirmasi =
            input.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {

            String nama =
                data[index].getNama();

            for (int i = index;
                 i < jumlah - 1;
                 i++) {

                data[i] = data[i + 1];
            }

            data[jumlah - 1] = null;

            jumlah--;

            System.out.println(
                "Data \""
                + nama
                + "\" berhasil dihapus."
            );

        } else {

            System.out.println(
                "Penghapusan dibatalkan."
            );
        }

        return jumlah;
    }

    public static void menuSimulasi(
            Scanner input,
            Latihan[] data,
            int jumlah) {

        if (jumlah == 0) {

            System.out.println(
                "Belum ada data latihan."
            );

            return;
        }

        System.out.println(
            "\n=== SIMULASI DYNAMIC BINDING ==="
        );

        for (int i = 0; i < jumlah; i++) {

            System.out.println(
                (i + 1)
                + ". "
                + data[i].getNama()
            );
        }

        System.out.print(
            "Pilih latihan: "
        );

        int pilihan =
            input.nextInt();

        input.nextLine();

        if (pilihan < 1 ||
            pilihan > jumlah) {

            System.out.println(
                "Pilihan tidak valid."
            );

            return;
        }

        Latihan pilihanLatihan =
            data[pilihan - 1];

        System.out.println(
            "\n1. Simulasi normal"
        );

        System.out.println(
            "2. Simulasi + durasi tambahan"
        );

        System.out.print(
            "Pilih: "
        );

        int jenis =
            input.nextInt();

        input.nextLine();

        if (jenis == 1) {

            prosesLatihan(
                pilihanLatihan
            );

        } else if (jenis == 2) {

            System.out.print(
                "Tambahan durasi: "
            );

            int tambahan =
                input.nextInt();

            input.nextLine();

            // METHOD OVERLOADING
            prosesLatihan(
                pilihanLatihan,
                tambahan
            );

        } else {

            System.out.println(
                "Pilihan tidak valid."
            );
        }
    }

    public static void main(String[] args) {

        Scanner input =
            new Scanner(System.in);

        Latihan[] data =
            new Latihan[KAPASITAS];

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
            new LatihanFleksibilitas(
                "Yoga",
                40,
                5,
                "Stretching",
                8
            );

        data[3] =
            new LatihanKekuatan(
                "Squat",
                40,
                9,
                "Kaki",
                50
            );

        data[4] =
            new LatihanKardio(
                "Bersepeda",
                60,
                7,
                "Cycling",
                12
            );

        int jumlah = 5;

        int pilihan;

        do {

            System.out.println(
                "\n=================================================="
            );

            System.out.println(
                "              FITTRACK"
            );

            System.out.println(
                "       POLYMORPHISM & DYNAMIC BINDING"
            );

            System.out.println(
                "=================================================="
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
                "4. Simulasi Dynamic Binding"
            );

            System.out.println(
                "5. Hapus Data"
            );

            System.out.println(
                "6. Keluar"
            );

            System.out.println(
                "=================================================="
            );

            System.out.print(
                "Pilih menu: "
            );

            pilihan =
                input.nextInt();

            input.nextLine();

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

                    System.out.println(
                        "\n=== PENCARIAN ==="
                    );

                    System.out.println(
                        "1. Berdasarkan nama"
                    );

                    System.out.println(
                        "2. Berdasarkan durasi"
                    );

                    System.out.print(
                        "Pilih: "
                    );

                    int jenisCari =
                        input.nextInt();

                    input.nextLine();

                    if (jenisCari == 1) {

                        System.out.print(
                            "Masukkan nama: "
                        );

                        String nama =
                            input.nextLine();

                        cariLatihan(
                            data,
                            jumlah,
                            nama
                        );

                    } else if (jenisCari == 2) {

                        System.out.print(
                            "Masukkan durasi: "
                        );

                        int durasi =
                            input.nextInt();

                        input.nextLine();

                        cariLatihan(
                            data,
                            jumlah,
                            durasi
                        );

                    } else {

                        System.out.println(
                            "Pilihan tidak valid."
                        );
                    }

                    break;

                case 4:

                    menuSimulasi(
                        input,
                        data,
                        jumlah
                    );

                    break;

                case 5:

                    jumlah =
                        hapusData(
                            input,
                            data,
                            jumlah
                        );

                    break;

                case 6:

                    System.out.println(
                        "\nTerima kasih telah menggunakan FitTrack!"
                    );

                    break;

                default:

                    System.out.println(
                        "\nPilihan menu tidak valid!"
                    );
            }

        } while (pilihan != 6);

        input.close();
    }
}