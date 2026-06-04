package com.inidivaragroup.jdt17.spring.dasar.exam.configuration;

import com.inidivaragroup.jdt17.spring.dasar.exam.model.Gudang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GudangConfiguration {
    @Bean
    public Gudang gudangUtama() {
        Gudang g = new Gudang();
        g.setNamaGudang("Gudang Utama");
        g.setStokBarang(1000);
        return g;
    }
}
