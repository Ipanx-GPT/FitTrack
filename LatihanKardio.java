package com.mycompany.fittrackapps;

public class LatihanKardio extends Latihan {

    // ==========================================
    // ATRIBUT KHUSUS SUBCLASS
    // ==========================================
    private String jenisKardio;
    private double jarakKm;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================
    public LatihanKardio(
            String nama,
            int durasiMenit,
            int intensitas,
            String jenisKardio,
            double jarakKm) {

        // Memanggil constructor superclass
        super(nama, durasiMenit, intensitas);

        this.setJenisKardio(jenisKardio);
        this.setJarakKm(jarakKm);
    }

    // ==========================================
    // GETTER JENIS KARDIO
    // ==========================================
    public String getJenisKardio() {
        return this.jenisKardio;
    }

    // ==========================================
    // SETTER JENIS KARDIO
    // ==========================================
    public void setJenisKardio(String jenisKardio) {

        if (jenisKardio != null && !jenisKardio.trim().isEmpty()) {
            this.jenisKardio = jenisKardio;
        } else {
            this.jenisKardio = "Kardio";
        }
    }

    // ==========================================
    // GETTER JARAK
    // ==========================================
    public double getJarakKm() {
        return this.jarakKm;
    }

    // ==========================================
    // SETTER JARAK
    // ==========================================
    public void setJarakKm(double jarakKm) {

        if (jarakKm >= 0 && jarakKm <= 200) {
            this.jarakKm = jarakKm;
        } else {
            this.jarakKm = 0;
        }
    }

    // ==========================================
    // METHOD OVERRIDING
    // ==========================================
    @Override
    public void tampilkanInfo() {

        super.tampilkanInfo();

        System.out.printf(
                "  %-18s | Jenis: %-16s | Jarak: %.1f km%n",
                "Latihan Kardio",
                this.jenisKardio,
                this.jarakKm
        );
    }

    // ==========================================
    // METHOD OVERRIDING
    // ==========================================
    @Override
    public void aksiKhusus() {

        super.aksiKhusus();

        System.out.println(
                "Aksi Kardio: Jaga ritme napas dan pertahankan "
                + "intensitas secara bertahap."
        );
    }
}