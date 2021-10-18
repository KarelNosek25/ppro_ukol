package cz.uhk.ppro.inzeraty;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Test implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    @Primary
    UlozisteInzeratu getInzeraty() {
        UlozisteInzeratu k = new PametoveUlozisteInzeratu();
        k.pridej(new Inzerat(1, "Nákup", "Koupím kolo", new BigDecimal(5000.00), LocalDate.now()));
        k.pridej(new Inzerat(1, "Nákup", "Koupím auto", new BigDecimal(150000.00), LocalDate.now()));
        k.pridej(new Inzerat(2, "Nákup", "Koupím stůl", new BigDecimal(300.00), LocalDate.now()));
        k.pridej(new Inzerat(3, "Prodej", "Prodám židli", new BigDecimal(400.00), LocalDate.now()));
        k.pridej(new Inzerat(4, "Výměna", "Vyměním kolo za jiné kolo", new BigDecimal(5000.00), LocalDate.now()));
        return k;
    }
}

