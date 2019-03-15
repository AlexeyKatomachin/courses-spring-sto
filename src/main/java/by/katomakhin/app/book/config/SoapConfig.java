package by.katomakhin.app.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan (value = "by.katomakhin.app.book")
public class SoapConfig {

    @Bean
    public SimpleJaxWsServiceExporter jaxWsExporter () {
        return new SimpleJaxWsServiceExporter();
    }

}
