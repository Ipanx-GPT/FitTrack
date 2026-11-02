package com.mycompany.fittracks;

public class LatihanKekuatan extends Latihan {

    private String targetOtot;
    private double bebanKg;

    public LatihanKekuatan(String nama, int durasiMenit,
            String intensitas, String targetOtot, double bebanKg) {

        super(nama, durasiMenit, intensitas);

        if (targetOtot == null || targetOtot.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Target otot tidak boleh kosong.");
        }

        if (bebanKg < 0) {
            throw new IllegalArgumentException(
                    "Beban tidak boleh negatif.");
        }

        this.targetOtot = targetOtot;
        this.bebanKg = bebanKg;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n[Latihan Kekuatan]");
        super.tampilkanInfo();
        System.out.println("Target otot: " + targetOtot);
        System.out.println("Beban      : " + bebanKg + " kg");
    }

    @Override
    public void aksiKhusus() {
        System.out.println(
                "Fokus pada teknik gerakan dan keselamatan saat mengangkat beban.");
    }
}