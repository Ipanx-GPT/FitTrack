package com.mycompany.fittracks;

public class Latihan {
    private String nama;
    private int durasiMenit;
    private int intensitas;
    private static int totalObjek = 0;

    public Latihan(String nama, int durasiMenit, int intensitas) {

        this.setNama(nama);
        this.setDurasiMenit(durasiMenit);
        this.setIntensitas(intensitas);

        totalObjek++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {

        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            this.nama = "Tanpa Nama";
        }
    }

    public int getDurasiMenit() {
        return this.durasiMenit;
    }

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

    public int getIntensitas() {
        return this.intensitas;
    }

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

    public static int getTotalObjek() {
        return totalObjek;
    }

    public void tampilkanInfo() {

        System.out.printf(
            "%-20s | %-10d | %-10d%n",
            nama,
            durasiMenit,
            intensitas
        );
    }

    public void aksiKhusus() {

        System.out.println(
            "Melakukan pemanasan sebelum latihan."
        );
    }
}