package cz.uhk.ppro.inzeraty.app;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        k.pridej(new Inzerat(1, "Nákup", "Koupím auto", 150000, "123456", tttt));
        k.pridej(new Inzerat(2, "Nákup", "Koupím stůl", 5000, "15948", "15.4.2020"));
        k.pridej(new Inzerat(3, "Prodej", "Prodám židli", 800, "78945", "16.2.2005"));
        k.pridej(new Inzerat(4, "Výměna", "Vyměním kolo za jiné kolo", 8500, "45689", "8.5.2021"));
        return k;
    }
}

