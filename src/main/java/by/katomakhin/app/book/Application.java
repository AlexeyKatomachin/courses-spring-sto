package by.katomakhin.app.book;

import by.katomakhin.app.book.config.SoapConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SoapConfig.class);
    }
}
