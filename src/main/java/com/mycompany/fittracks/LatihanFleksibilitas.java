package com.mycompany.fittracks;

public class LatihanFleksibilitas extends Latihan {

    private String jenisPeregangan;
    private int jumlahGerakan;

    public LatihanFleksibilitas(String nama, int durasiMenit,
            String intensitas, String jenisPeregangan,
            int jumlahGerakan) {

        super(nama, durasiMenit, intensitas);

        if (jenisPeregangan == null
                || jenisPeregangan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Jenis peregangan tidak boleh kosong.");
        }

        if (jumlahGerakan <= 0) {
            throw new IllegalArgumentException(
                    "Jumlah gerakan harus lebih dari 0.");
        }

        this.jenisPeregangan = jenisPeregangan;
        this.jumlahGerakan = jumlahGerakan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n[Latihan Fleksibilitas]");
        super.tampilkanInfo();
        System.out.println("Jenis peregangan: " + jenisPeregangan);
        System.out.println("Jumlah gerakan  : " + jumlahGerakan);
    }

    @Override
    public void aksiKhusus() {
        System.out.println(
                "Lakukan peregangan secara perlahan tanpa memaksakan tubuh.");
    }
}