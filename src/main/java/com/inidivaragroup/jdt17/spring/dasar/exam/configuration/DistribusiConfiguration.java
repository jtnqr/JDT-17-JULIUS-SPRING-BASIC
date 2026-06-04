package com.inidivaragroup.jdt17.spring.dasar.exam.configuration;

import com.inidivaragroup.jdt17.spring.dasar.exam.DistribusiService;
import com.inidivaragroup.jdt17.spring.dasar.exam.model.Gudang;
import com.inidivaragroup.jdt17.spring.dasar.exam.service.Sales;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistribusiConfiguration {
    @Bean
    public DistribusiService distribusiService(
            Gudang gudang,
            @Qualifier("motor1") Sales salesSatu,
            @Qualifier("motor2") Sales salesDua,
            @Qualifier("motor3") Sales salesTiga,
            @Qualifier("mobil1") Sales salesEmpat,
            @Qualifier("mobil2") Sales salesLima
    ) {return  new DistribusiService(gudang, salesSatu, salesDua, salesTiga, salesEmpat, salesLima);}
}
