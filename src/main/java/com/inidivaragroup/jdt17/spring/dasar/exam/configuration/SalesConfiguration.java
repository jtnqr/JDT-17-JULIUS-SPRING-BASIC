package com.inidivaragroup.jdt17.spring.dasar.exam.configuration;

import com.inidivaragroup.jdt17.spring.dasar.exam.service.Sales;
import com.inidivaragroup.jdt17.spring.dasar.exam.service.SalesMobil;
import com.inidivaragroup.jdt17.spring.dasar.exam.service.SalesMotor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesConfiguration {
    @Bean
    @Qualifier("motor1")
    public Sales motor1() {return new SalesMotor("Andi", "Zona A");}

    @Bean
    @Qualifier("motor2")
    public Sales motor2() {return new SalesMotor("Budi", "Zona B");}

    @Bean
    @Qualifier("motor3")
    public Sales motor3() {return new SalesMotor("Cici", "Zona C");}

    @Bean
    @Qualifier("mobil1")
    public Sales mobil1() {return new SalesMobil("Dedi", "Zona D");}

    @Bean
    @Qualifier("mobil2")
    public Sales mobil2() {return new SalesMobil("Eka", "Zona E");}
}
