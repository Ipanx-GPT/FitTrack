package com.mycompany.fittracks;

public class LatihanFleksibilitas extends Latihan {

    private String jenisPeregangan;
    private int jumlahGerakan;

    public LatihanFleksibilitas(
            String nama,
            int durasiMenit,
            int intensitas,
            String jenisPeregangan,
            int jumlahGerakan) {

        super(nama, durasiMenit, intensitas);

        this.setJenisPeregangan(jenisPeregangan);
        this.setJumlahGerakan(jumlahGerakan);
    }

    public String getJenisPeregangan() {
        return this.jenisPeregangan;
    }

    public void setJenisPeregangan(String jenisPeregangan) {

        if (jenisPeregangan != null &&
            !jenisPeregangan.trim().isEmpty()) {

            this.jenisPeregangan = jenisPeregangan;

        } else {

            this.jenisPeregangan = "Stretching";
        }
    }

    public int getJumlahGerakan() {
        return this.jumlahGerakan;
    }

    public void setJumlahGerakan(int jumlahGerakan) {

        if (jumlahGerakan > 0 &&
            jumlahGerakan <= 100) {

            this.jumlahGerakan = jumlahGerakan;

        } else {

            this.jumlahGerakan = 1;
        }
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
            "Jenis              : Latihan Fleksibilitas"
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
            "Jenis Peregangan   : " + jenisPeregangan
        );

        System.out.println(
            "Jumlah Gerakan     : " + jumlahGerakan
        );
    }

    @Override
    public void aksiKhusus() {

        System.out.println(
            "Latihan Fleksibilitas: "
            + "lakukan peregangan secara perlahan "
            + "dan jangan memaksakan gerakan."
        );
    }
}
