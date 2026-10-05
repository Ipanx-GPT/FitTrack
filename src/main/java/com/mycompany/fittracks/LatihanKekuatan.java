package com.mycompany.fittracks;

public class LatihanKekuatan extends Latihan {

    private String targetOtot;
    private double bebanKg;

    public LatihanKekuatan(
            String nama,
            int durasiMenit,
            int intensitas,
            String targetOtot,
            double bebanKg) {

        // SUPER
        super(nama, durasiMenit, intensitas);

        this.setTargetOtot(targetOtot);
        this.setBebanKg(bebanKg);
    }

    public String getTargetOtot() {
        return this.targetOtot;
    }

    public void setTargetOtot(String targetOtot) {

        if (targetOtot != null &&
            !targetOtot.trim().isEmpty()) {

            this.targetOtot = targetOtot;

        } else {

            this.targetOtot = "Umum";
        }
    }

    public double getBebanKg() {
        return this.bebanKg;
    }

    public void setBebanKg(double bebanKg) {

        if (bebanKg >= 0 && bebanKg <= 500) {
            this.bebanKg = bebanKg;
        } else {
            this.bebanKg = 0;
        }
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
            "Jenis              : Latihan Kekuatan"
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
            "Target Otot        : " + targetOtot
        );

        System.out.println(
            "Beban              : " + bebanKg
            + " kg"
        );
    }

    @Override
    public void aksiKhusus() {

        System.out.println(
            "Latihan Kekuatan: "
            + "gunakan teknik yang benar dan "
            + "sesuaikan beban dengan kemampuan."
        );
    }
}