package com.mycompany.fittracks;

public abstract class Latihan {

    protected String nama;
    protected int durasiMenit;
    protected String intensitas;

    public Latihan(String nama, int durasiMenit, String intensitas) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama latihan tidak boleh kosong.");
        }

        if (durasiMenit <= 0) {
            throw new IllegalArgumentException(
                    "Durasi harus lebih dari 0 menit.");
        }

        if (intensitas == null || intensitas.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Intensitas tidak boleh kosong.");
        }

        this.nama = nama.trim();
        this.durasiMenit = durasiMenit;
        this.intensitas = intensitas.trim();
    }

    public String getNama() {
        return nama;
    }

    public int getDurasiMenit() {
        return durasiMenit;
    }

    public String getIntensitas() {
        return intensitas;
    }

    public void tampilkanInfo() {
        System.out.println("Nama       : " + nama);
        System.out.println("Durasi     : " + durasiMenit + " menit");
        System.out.println("Intensitas : " + intensitas);
    }

    public abstract void aksiKhusus();
}