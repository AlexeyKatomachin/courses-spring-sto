package by.katomakhin.app.sto.conf.demo;

import by.katomakhin.app.sto.service.ICertificateOfCompletionService;
import by.katomakhin.app.sto.service.IPointService;
import by.katomakhin.app.sto.service.demo.DemoCertificateOfCompletionService;
import by.katomakhin.app.sto.service.demo.DemoPointService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("demo")
public class DemoConfig {
    @Bean
    public ICertificateOfCompletionService getCertModel(){
        return new DemoCertificateOfCompletionService();
    }

    @Bean
    public IPointService getPointModel(){
        return new DemoPointService();
    }
}
