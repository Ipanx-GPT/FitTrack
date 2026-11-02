package com.mycompany.fittracks;

public class LatihanKardio extends Latihan {

    private String jenisKardio;
    private double jarakKm;

    public LatihanKardio(String nama, int durasiMenit,
            String intensitas, String jenisKardio, double jarakKm) {

        super(nama, durasiMenit, intensitas);

        if (jenisKardio == null || jenisKardio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Jenis kardio tidak boleh kosong.");
        }

        if (jarakKm < 0) {
            throw new IllegalArgumentException(
                    "Jarak tidak boleh negatif.");
        }

        this.jenisKardio = jenisKardio;
        this.jarakKm = jarakKm;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n[Latihan Kardio]");
        super.tampilkanInfo();
        System.out.println("Jenis kardio: " + jenisKardio);
        System.out.println("Jarak       : " + jarakKm + " km");
    }

    @Override
    public void aksiKhusus() {
        System.out.println(
                "Lakukan pemanasan dan jaga ritme pernapasan selama kardio.");
    }
}