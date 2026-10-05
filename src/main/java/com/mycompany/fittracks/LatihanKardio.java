package com.mycompany.fittracks;

public class LatihanKardio extends Latihan {

    private String jenisKardio;
    private double jarakKm;

    public LatihanKardio(
            String nama,
            int durasiMenit,
            int intensitas,
            String jenisKardio,
            double jarakKm) {

        super(nama, durasiMenit, intensitas);

        this.setJenisKardio(jenisKardio);
        this.setJarakKm(jarakKm);
    }

    public String getJenisKardio() {
        return this.jenisKardio;
    }

    public void setJenisKardio(String jenisKardio) {

        if (jenisKardio != null &&
            !jenisKardio.trim().isEmpty()) {

            this.jenisKardio = jenisKardio;

        } else {

            this.jenisKardio = "Kardio";
        }
    }

    public double getJarakKm() {
        return this.jarakKm;
    }

    public void setJarakKm(double jarakKm) {

        if (jarakKm >= 0 && jarakKm <= 200) {
            this.jarakKm = jarakKm;
        } else {
            this.jarakKm = 0;
        }
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
            "Jenis              : Latihan Kardio"
        );

        System.out.println(
            "Nama               : " + getNama()
        );

        System.out.println(
            "Durasi             : " + getDurasiMenit()
            + " menit"
        );

        System.out.println(
            "Intensitas         : " + getIntensitas()
            + "/10"
        );

        System.out.println(
            "Jenis Kardio       : " + jenisKardio
        );

        System.out.println(
            "Jarak              : " + jarakKm
            + " km"
        );
    }

    @Override
    public void aksiKhusus() {

        System.out.println(
            "Latihan Kardio: "
            + "jaga ritme pernapasan dan "
            + "pertahankan intensitas secara bertahap."
        );
    }
}