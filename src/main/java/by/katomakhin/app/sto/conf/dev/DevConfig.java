package by.katomakhin.app.sto.conf.dev;

import by.katomakhin.app.sto.dao.certificate.local.map.CertMapRepository;
import by.katomakhin.app.sto.dao.point.locale.map.PointMapRepository;
import by.katomakhin.app.sto.service.ICertificateOfCompletionService;
import by.katomakhin.app.sto.service.IPointService;
import by.katomakhin.app.sto.service.dev.CertificateOfCompletionService;
import by.katomakhin.app.sto.service.dev.PointsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public ICertificateOfCompletionService getCertModel(){
        return new CertificateOfCompletionService(new CertMapRepository());
    }

    @Bean
    public IPointService getPointModel(){
        return new PointsService(new PointMapRepository());
    }
}
