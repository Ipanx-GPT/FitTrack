package com.mycompany.fittracks;

public class LatihanFleksibilitas extends Latihan
        implements DapatDiberiTarget {

    private String jenisPeregangan;
    private int jumlahGerakan;

    public LatihanFleksibilitas(String nama, int durasiMenit,
            String intensitas, String jenisPeregangan,
            int jumlahGerakan) {
        super(nama, durasiMenit, intensitas);
        this.jenisPeregangan = jenisPeregangan;
        this.jumlahGerakan = jumlahGerakan;
    }

    @Override
    public void aksiKhusus() {
        System.out.println("Aksi fleksibilitas: lakukan peregangan "
                + jenisPeregangan + " secara perlahan.");
        System.out.println("Jumlah gerakan: " + jumlahGerakan + ".");
    }

    @Override
    public void tampilkanTarget() {
        System.out.println("Target fleksibilitas: menyelesaikan "
                + jumlahGerakan + " gerakan " + jenisPeregangan + ".");
    }
}