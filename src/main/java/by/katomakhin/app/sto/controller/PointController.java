package by.katomakhin.app.sto.controller;

import by.katomakhin.app.sto.conf.ApplicationConfig;
import by.katomakhin.app.sto.conf.RootConfig;
import by.katomakhin.app.sto.conf.WebConfig;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ContextConfiguration(classes = {ApplicationConfig.class, RootConfig.class, WebConfig.class})
@ActiveProfiles("dev")
public class PointController {
    IPointService service;

    @Autowired
    public PointController(@Qualifier("pointsService") IPointService service) {
        this.service = service;
    }

    @GetMapping(path = "/points/{model}")
    public ModelAndView getPoints(ModelAndView modelAndView, @PathVariable String model){
        modelAndView.addObject("points", service.getPointsByModel(model));
        modelAndView.setViewName("point/pointsList");
        return modelAndView;
    }

    @GetMapping(path = "/points/editPoint/{id}")
    public ModelAndView getPoints(ModelAndView modelAndView, @PathVariable int id){
        modelAndView.addObject("point", service.getPoint(id));
        modelAndView.setViewName("point/editPoint");
        return modelAndView;
    }

    @GetMapping(path = "/points/editPoint")
    public String getPoints(PointOfCertificate point){
        service.updatePoint("bmw", point.getId(), point.getPrice().doubleValue(), point.getName());
        return "redirect:point/pointsList";
    }


}
