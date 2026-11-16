package com.mycompany.fittracks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FITTRACKS {

    private static final Scanner input =
            new Scanner(System.in);

    private static final FitTrack fitTrack =
            new FitTrack();

    private static final TransaksiFitTrack transaksi =
            new TransaksiFitTrack();

    public static void main(String[] args) {

        System.out.println("\n===== MEMUAT DATA FITTRACK =====");

        boolean dataTersedia = fitTrack.muatDataDariFile();

        if (!dataTersedia) {
            System.out.println(
                    "[INFO] Menggunakan data awal FITTRACK.");

            isiDataAwal();
        }

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
                            fitTrack.tampilkanSemuaLatihan();
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
                            menuPengguna();
                            break;

                        case 7:
                            fitTrack.tampilkanDashboard();
                            break;

                        case 8:
                            simulasiTransaksi();
                            break;

                        case 9:
                            tampilkanTargetLatihan();
                            break;

                        case 10:
                            fitTrack.simpanDataKeFile();
                            break;

                        case 11:
                            fitTrack.muatDataDariFile();
                            break;

                        case 12:
                            fitTrack.bacaLogTransaksi();
                            break;

                        case 0:
                            System.out.println(
                                    "\nMenyimpan data sebelum keluar...");

                            fitTrack.simpanDataKeFile();
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
                            "Error: " + e.getMessage());

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
        System.out.println("6. Kelola pengguna");
        System.out.println("7. Dashboard FitTrack");
        System.out.println("8. Simulasi transaksi latihan");
        System.out.println("9. Tampilkan target latihan");
        System.out.println("10. Simpan data ke file");
        System.out.println("11. Muat data dari file");
        System.out.println("12. Tampilkan log aktivitas");
        System.out.println("0. Keluar");

        System.out.println(
                "Jumlah latihan: "
                + fitTrack.getJumlahLatihan());

        System.out.println("==============================");
    }

    private static void isiDataAwal() {

        fitTrack.tambahLatihan(
                new LatihanKekuatan(
                        "Bench Press", 30,
                        "Tinggi", "Dada", 40));

        fitTrack.tambahLatihan(
                new LatihanKardio(
                        "Lari Pagi", 25,
                        "Sedang", "Lari", 3.0));

        fitTrack.tambahLatihan(
                new LatihanFleksibilitas(
                        "Yoga", 20,
                        "Rendah", "Yoga", 8));

        fitTrack.tambahLatihan(
                new LatihanKekuatan(
                        "Squat", 20,
                        "Sedang", "Kaki", 25));

        fitTrack.tambahLatihan(
                new LatihanKardio(
                        "Bersepeda", 45,
                        "Sedang", "Sepeda", 10.5));

        fitTrack.tambahPengguna(
                new Pengguna("FT001", "Irfan Ahmad"));

        fitTrack.tambahPengguna(
                new Pengguna("FT002", "Nadia Putri"));

        fitTrack.tambahPengguna(
                new Pengguna("FT003", "Rian Saputra"));
    }

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
                        nama, durasi, intensitas,
                        target, beban);
                break;

            case 2:
                System.out.print("Jenis kardio: ");
                String tipe = input.nextLine();

                System.out.print("Jarak (km): ");
                double jarak = input.nextDouble();
                input.nextLine();

                latihan = new LatihanKardio(
                        nama, durasi, intensitas,
                        tipe, jarak);
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

        fitTrack.tambahLatihan(latihan);
    }

    private static void cariLatihanMenu()
            throws LatihanTidakDitemukanException {

        System.out.print("Masukkan nama latihan: ");
        String nama = input.nextLine();

        Latihan hasil = fitTrack.cariLatihan(nama);

        System.out.println("\nData ditemukan:");
        hasil.tampilkanInfo();
    }

    private static void simulasiDynamicBinding()
            throws LatihanTidakDitemukanException {

        System.out.print("Nama latihan: ");
        String nama = input.nextLine();

        Latihan hasil = fitTrack.cariLatihan(nama);
        hasil.aksiKhusus();
    }

    private static void hapusLatihan()
            throws LatihanTidakDitemukanException {

        System.out.print("Nama latihan yang dihapus: ");
        String nama = input.nextLine();

        fitTrack.hapusLatihan(nama);
    }

    private static void menuPengguna() {

        boolean kembali = false;

        while (!kembali) {

            System.out.println("\n===== KELOLA PENGGUNA =====");
            System.out.println("1. Tambah pengguna");
            System.out.println("2. Cari pengguna");
            System.out.println("3. Tampilkan semua pengguna");
            System.out.println("0. Kembali");

            try {

                System.out.print("Pilih menu: ");
                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {

                    case 1:
                        tambahPengguna();
                        break;

                    case 2:
                        cariPengguna();
                        break;

                    case 3:
                        fitTrack.tampilkanSemuaPengguna();
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
                        "Input harus berupa angka.");

                input.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage());

            } finally {

                System.out.println(
                        "[INFO] Operasi pengguna selesai.");
            }
        }
    }

    private static void tambahPengguna() {

        System.out.print("ID pengguna: ");
        String id = input.nextLine();

        System.out.print("Nama pengguna: ");
        String nama = input.nextLine();

        Pengguna pengguna = new Pengguna(id, nama);
        fitTrack.tambahPengguna(pengguna);
    }

    private static void cariPengguna() {

        System.out.print("Masukkan ID pengguna: ");
        String id = input.nextLine();

        Pengguna pengguna = fitTrack.cariPengguna(id);

        System.out.println("\nPengguna ditemukan:");
        pengguna.tampilkanInfo();
    }

    private static void simulasiTransaksi() {

        System.out.println("\n===== TRANSAKSI LATIHAN =====");

        System.out.print("Masukkan ID pengguna: ");
        String id = input.nextLine();

        Pengguna pengguna = fitTrack.cariPengguna(id);

        fitTrack.tampilkanSemuaLatihan();

        if (fitTrack.getJumlahLatihan() == 0) {
            System.out.println("Tidak ada latihan tersedia.");
            return;
        }

        System.out.print("\nPilih nomor latihan: ");

        int nomor = input.nextInt();
        input.nextLine();

        Latihan latihan = fitTrack.getLatihan(nomor - 1);

        transaksi.catatLatihan(pengguna, latihan);
        latihan.catatAktivitas();
    }

    private static void tampilkanTargetLatihan() {

        fitTrack.tampilkanSemuaLatihan();

        if (fitTrack.getJumlahLatihan() == 0) {
            return;
        }

        System.out.print("\nPilih nomor latihan: ");

        int nomor = input.nextInt();
        input.nextLine();

        Latihan latihan = fitTrack.getLatihan(nomor - 1);

        latihan.tampilkanTarget();
    }
}