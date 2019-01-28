package by.katomakhin.app.sto.controller;

import by.katomakhin.app.sto.conf.ApplicationConfig;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.service.dev.CertificateOfCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@ContextConfiguration(classes = ApplicationConfig.class)
//@ActiveProfiles("dev")
public class CertificateOfCompletionController {
    private CertificateOfCompletionService service;

    @Autowired
    public CertificateOfCompletionController(CertificateOfCompletionService service) {
        this.service = service;
    }

    @GetMapping(value = "/cert/{model}/{licensePlate}")
    public ModelAndView getCertificate (ModelAndView modelAndView,@PathVariable String model, @PathVariable String licensePlate){
        List<CertificateOfCompletion> cert = service.getCompleteCertificateOfCompletion(model, licensePlate);
        modelAndView.addObject(cert);
        modelAndView.setViewName("workList");
        return modelAndView;
    }
}
                   