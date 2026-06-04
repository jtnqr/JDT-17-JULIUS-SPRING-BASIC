package com.inidivaragroup.jdt17.spring.dasar.exam;

import com.inidivaragroup.jdt17.spring.dasar.exam.model.Gudang;
import com.inidivaragroup.jdt17.spring.dasar.exam.service.Sales;

import java.util.List;

public class DistribusiService {
    private final Gudang gudang;
    private final Sales salesSatu, salesDua, salesTiga, salesEmpat, salesLima;

    public DistribusiService(
            Gudang gudang,
            Sales salesSatu,
            Sales salesDua,
            Sales salesTiga,
            Sales salesEmpat,
            Sales salesLima
    ) {
        this.gudang = gudang;
        this.salesSatu = salesSatu;
        this.salesDua = salesDua;
        this.salesTiga = salesTiga;
        this.salesEmpat = salesEmpat;
        this.salesLima = salesLima;
    }

    public void distribusiBarang() {
        var daftarSales = List.of(salesSatu, salesDua, salesTiga, salesEmpat, salesLima);

        for (var sales : daftarSales) {
            System.out.println
                    ("[DISTRIBUSI] Sales: " + sales.getNama() +
                    " | Wilayah: " + sales.getWilayah() +
                    " | Kendaraan: " + sales.getTipeKendaraan() +
                    " | Gudang: " + gudang.getNamaGudang() +
                    "(stok: " + gudang.getStokBarang() + ")");

            gudang.kurangiStok(50);
        }

        System.out.println("\n[SISA STOK] " + gudang.getNamaGudang() + ": " + gudang.getStokBarang() + " unit");
    }
}
