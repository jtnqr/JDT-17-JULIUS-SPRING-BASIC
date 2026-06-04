package com.inidivaragroup.jdt17.spring.dasar.exam.service;

import lombok.Getter;

@Getter
public class SalesMobil implements Sales{
    private final String nama;
    private final String wilayah;
    private final String tipeKendaraan = "Mobil";

    public SalesMobil(String nama, String wilayah) {
        this.nama = nama;
        this.wilayah = wilayah;
    }
}
