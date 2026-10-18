package com.mycompany.fittracks;

public class LatihanKardio extends Latihan
        implements DapatDilacak {

    private String jenisKardio;
    private double jarakKm;

    public LatihanKardio(String nama, int durasiMenit,
            String intensitas, String jenisKardio, double jarakKm) {
        super(nama, durasiMenit, intensitas);
        this.jenisKardio = jenisKardio;
        this.jarakKm = jarakKm;
    }

    @Override
    public void aksiKhusus() {
        System.out.println("Aksi kardio: lakukan " + jenisKardio
                + " dengan tempo " + intensitas + ".");
        System.out.println("Jarak yang direncanakan: "
                + jarakKm + " km.");
    }

    @Override
    public void catatAktivitas() {
        System.out.println("Aktivitas kardio '" + nama
                + "' dicatat: " + jarakKm + " km dalam "
                + durasiMenit + " menit.");
    }
}