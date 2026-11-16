package com.mycompany.fittracks;

import java.io.Serializable;

public class Pengguna implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nama;

    public Pengguna(String id, String nama) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID pengguna tidak boleh kosong.");
        }

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama pengguna tidak boleh kosong.");
        }

        this.id = id.trim();
        this.nama = nama.trim();
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("ID   : " + id);
        System.out.println("Nama : " + nama);
    }
}