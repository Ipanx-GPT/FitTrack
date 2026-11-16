package com.mycompany.fittracks;

public class DashboardFitTrack {

    public DashboardFitTrack() {
        System.out.println(
                "[SYSTEM] Dashboard FitTrack berhasil dibuat.");
    }

    public void tampilkanDashboard(
            int jumlahLatihan, int jumlahPengguna) {

        System.out.println("\n====== DASHBOARD FITTRACK ======");
        System.out.println("Total jenis latihan : " + jumlahLatihan);
        System.out.println("Total pengguna      : " + jumlahPengguna);
        System.out.println("Status sistem       : Aktif");
        System.out.println("================================");
    }
}