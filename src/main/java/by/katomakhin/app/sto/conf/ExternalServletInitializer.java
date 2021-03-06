package by.katomakhin.app.sto.conf;

import by.katomakhin.app.sto.servlet.ExternalServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ExternalServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("mySuperServlet", ExternalServlet.class);
        myServlet.addMapping("/myCustomSuperExternalLink/**");
    }
}
