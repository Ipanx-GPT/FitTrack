
package com.mycompany.fittracks;

public class TransaksiFitTrack {

    public void catatLatihan(
            Pengguna pengguna, Latihan latihan) {

        if (pengguna == null || latihan == null) {
            throw new IllegalArgumentException(
                    "Pengguna dan latihan harus tersedia.");
        }

        System.out.println("\n===== TRANSAKSI LATIHAN =====");

        System.out.println(
                "Nama pengguna : " + pengguna.getNama());

        System.out.println(
                "ID pengguna   : " + pengguna.getId());

        System.out.println(
                "Nama latihan  : " + latihan.getNama());

        System.out.println(
                "Durasi        : "
                + latihan.getDurasiMenit() + " menit");

        System.out.println(
                "Intensitas    : " + latihan.getIntensitas());

        System.out.println(
                "Status        : BERHASIL DICATAT");

        System.out.println("=============================");
    }
}
