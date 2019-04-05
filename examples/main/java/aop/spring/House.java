package aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aop.spring.configuration.HouseHelperConfiguration;
import aop.spring.helper.HouseHelper;

public class House {


    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(HouseHelperConfiguration.class);

        HouseHelper plumber = annotationContext.getBean("plumber", HouseHelper.class);
        HouseHelper builder = annotationContext.getBean("builder", HouseHelper.class);

        builder.fixBuilding();
        plumber.fixBuilding();
    }
}
