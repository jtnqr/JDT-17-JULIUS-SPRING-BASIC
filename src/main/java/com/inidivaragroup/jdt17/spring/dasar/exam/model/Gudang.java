package com.inidivaragroup.jdt17.spring.dasar.exam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Gudang {
    private String namaGudang;
    private int stokBarang;

    public void kurangiStok(int jumlah) {
        this.stokBarang -= jumlah;
    }
}
