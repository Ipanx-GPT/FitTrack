package com.mycompany.fittrackapps;

public class LatihanKekuatan extends Latihan {

    // ==========================================
    // ATRIBUT KHUSUS SUBCLASS
    // ==========================================
    private String targetOtot;
    private double bebanKg;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================
    public LatihanKekuatan(
            String nama,
            int durasiMenit,
            int intensitas,
            String targetOtot,
            double bebanKg) {

        // Memanggil constructor superclass
        super(nama, durasiMenit, intensitas);

        this.setTargetOtot(targetOtot);
        this.setBebanKg(bebanKg);
    }

    // ==========================================
    // GETTER TARGET OTOT
    // ==========================================
    public String getTargetOtot() {
        return this.targetOtot;
    }

    // ==========================================
    // SETTER TARGET OTOT
    // ==========================================
    public void setTargetOtot(String targetOtot) {

        if (targetOtot != null && !targetOtot.trim().isEmpty()) {
            this.targetOtot = targetOtot;
        } else {
            this.targetOtot = "Umum";
        }
    }

    // ==========================================
    // GETTER BEBAN
    // ==========================================
    public double getBebanKg() {
        return this.bebanKg;
    }

    // ==========================================
    // SETTER BEBAN
    // ==========================================
    public void setBebanKg(double bebanKg) {

        if (bebanKg >= 0 && bebanKg <= 500) {
            this.bebanKg = bebanKg;
        } else {
            this.bebanKg = 0;
        }
    }

    // ==========================================
    // METHOD OVERRIDING
    // ==========================================
    @Override
    public void tampilkanInfo() {

        super.tampilkanInfo();

        System.out.printf(
                "  %-18s | Target Otot: %-15s | Beban: %.1f kg%n",
                "Latihan Kekuatan",
                this.targetOtot,
                this.bebanKg
        );
    }

    // ==========================================
    // METHOD OVERRIDING
    // ==========================================
    @Override
    public void aksiKhusus() {

        super.aksiKhusus();

        System.out.println(
                "Aksi Kekuatan: Gunakan teknik yang benar "
                + "dan sesuaikan beban dengan kemampuan."
        );
    }
}