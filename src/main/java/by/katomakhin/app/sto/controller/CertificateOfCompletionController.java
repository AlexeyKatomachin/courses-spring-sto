package by.katomakhin.app.sto.controller;

import by.katomakhin.app.sto.conf.ApplicationConfig;
import by.katomakhin.app.sto.service.dev.CertificateOfCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@ContextConfiguration(classes = ApplicationConfig.class)
//@ActiveProfiles("dev")
public class CertificateOfCompletionController {
    private CertificateOfCompletionService service;

    @Autowired
    public CertificateOfCompletionController(CertificateOfCompletionService service) {
        this.service = service;
    }

    @GetMapping(value = "/cert/{licensePlate}")
    public String getCertificate (String licensePlate){

    }
}
                   