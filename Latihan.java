package com.mycompany.fittrackapps;

public class Latihan {

    // ==========================================
    // ENCAPSULATION
    // Semua atribut dibuat private
    // ==========================================
    private String nama;
    private int durasiMenit;
    private int intensitas;

    // ==========================================
    // STATIC
    // Menghitung total objek yang dibuat
    // ==========================================
    private static int totalLatihan = 0;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================
    public Latihan(String nama, int durasiMenit, int intensitas) {

        this.setNama(nama);
        this.setDurasiMenit(durasiMenit);
        this.setIntensitas(intensitas);

        totalLatihan++;
    }

    // ==========================================
    // GETTER NAMA
    // ==========================================
    public String getNama() {
        return this.nama;
    }

    // ==========================================
    // SETTER NAMA
    // ==========================================
    public void setNama(String nama) {

        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            this.nama = "Tanpa Nama";
        }
    }

    // ==========================================
    // GETTER DURASI
    // ==========================================
    public int getDurasiMenit() {
        return this.durasiMenit;
    }

    // ==========================================
    // SETTER DURASI
    // ==========================================
    public void setDurasiMenit(int durasiMenit) {

        if (durasiMenit > 0 && durasiMenit <= 300) {
            this.durasiMenit = durasiMenit;
        } else {
            System.out.println(
                    "Durasi tidak valid. Durasi diatur menjadi 30 menit."
            );

            this.durasiMenit = 30;
        }
    }

    // ==========================================
    // GETTER INTENSITAS
    // ==========================================
    public int getIntensitas() {
        return this.intensitas;
    }

    // ==========================================
    // SETTER INTENSITAS
    // ==========================================
    public void setIntensitas(int intensitas) {

        if (intensitas >= 1 && intensitas <= 10) {
            this.intensitas = intensitas;
        } else {
            System.out.println(
                    "Intensitas tidak valid. Intensitas diatur menjadi 5."
            );

            this.intensitas = 5;
        }
    }

    // ==========================================
    // STATIC METHOD
    // ==========================================
    public static int getTotalLatihan() {
        return totalLatihan;
    }

    // ==========================================
    // METHOD YANG AKAN DI-OVERRIDE
    // ==========================================
    public void tampilkanInfo() {

        System.out.printf(
                "%-18s | %-10s | %-10s%n",
                this.nama,
                this.durasiMenit + " mnt",
                this.intensitas + "/10"
        );
    }

    // ==========================================
    // METHOD YANG AKAN DI-OVERRIDE
    // ==========================================
    public void aksiKhusus() {

        System.out.println(
                "Pemanasan sebelum melakukan latihan."
        );
    }
}