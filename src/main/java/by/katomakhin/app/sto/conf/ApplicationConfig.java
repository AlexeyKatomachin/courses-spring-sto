package by.katomakhin.app.sto.conf;

import by.katomakhin.app.sto.conf.demo.DemoConfig;
import by.katomakhin.app.sto.conf.dev.DevConfig;
import by.katomakhin.app.sto.dao.certificate.local.map.CertMapRepository;
import by.katomakhin.app.sto.dao.point.locale.map.PointMapRepository;
import by.katomakhin.app.sto.service.ICertificateOfCompletionService;
import by.katomakhin.app.sto.service.IPointService;
import by.katomakhin.app.sto.service.dev.CertificateOfCompletionService;
import by.katomakhin.app.sto.service.dev.PointsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import({DemoConfig.class, DevConfig.class})
public class ApplicationConfig {

    @Bean
    @Profile("default")
    public ICertificateOfCompletionService getCertModel() {
        return new CertificateOfCompletionService(new CertMapRepository());
    }

    @Bean
    @Profile("default")
    public IPointService getPointModel() {
        return new PointsService(new PointMapRepository());
    }
}
