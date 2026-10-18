package com.mycompany.fittracks;

public class LatihanKekuatan extends Latihan
        implements DapatDilacak, DapatDiberiTarget {

    private String targetOtot;
    private double bebanKg;

    public LatihanKekuatan(String nama, int durasiMenit,
            String intensitas, String targetOtot, double bebanKg) {
        super(nama, durasiMenit, intensitas);
        this.targetOtot = targetOtot;
        this.bebanKg = bebanKg;
    }

    @Override
    public void aksiKhusus() {
        System.out.println(
            "Aksi latihan kekuatan: lakukan gerakan dengan teknik yang benar."
        );
        System.out.println("Target otot: " + targetOtot
                + ", beban: " + bebanKg + " kg.");
    }

    @Override
    public void catatAktivitas() {
        System.out.println("Aktivitas kekuatan '" + nama
                + "' dicatat selama " + durasiMenit + " menit.");
    }

    @Override
    public void tampilkanTarget() {
        System.out.println("Target latihan: melatih otot "
                + targetOtot + " menggunakan beban "
                + bebanKg + " kg.");
    }
}