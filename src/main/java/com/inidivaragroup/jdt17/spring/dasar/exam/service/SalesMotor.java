package com.inidivaragroup.jdt17.spring.dasar.exam.service;

import lombok.Getter;

@Getter
public class SalesMotor implements Sales{
    private final String nama;
    private final String wilayah;
    private final String tipeKendaraan = "Motor";

    public SalesMotor(String nama, String wilayah) {
        this.nama = nama;
        this.wilayah = wilayah;
    }
}
