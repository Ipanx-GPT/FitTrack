package com.mycompany.fittracks;

public abstract class Latihan {
    protected String nama;
    protected int durasiMenit;
    protected String intensitas;

    public Latihan(String nama, int durasiMenit, String intensitas) {
        this.nama = nama;
        this.durasiMenit = durasiMenit;
        this.intensitas = intensitas;
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
