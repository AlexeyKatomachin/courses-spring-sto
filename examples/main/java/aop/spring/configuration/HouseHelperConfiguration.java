package aop.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import aop.spring.instruments.PlumberInstruments;
import aop.spring.helper.HouseHelper;
import aop.spring.instruments.BuilderInstruments;
import aop.spring.instruments.support.InstrumentCleaner;
import aop.spring.instruments.Intruments;

@Configuration
@EnableAspectJAutoProxy
public class HouseHelperConfiguration {
    @Bean
    public HouseHelper builder(){
        return new HouseHelper(builderInstruments());
    }

    @Bean
    public HouseHelper plumber(){
        return new HouseHelper(plumberInstruments());
    }

    @Bean
    public Intruments builderInstruments(){
        return new BuilderInstruments();
    }

    @Bean
    public Intruments plumberInstruments(){
        return new PlumberInstruments();
    }

    @Bean
    public InstrumentCleaner cashier(){
        return new InstrumentCleaner();
    }
}
