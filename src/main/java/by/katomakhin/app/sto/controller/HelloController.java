package by.katomakhin.app.sto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(path = "/hello")
    public ModelAndView helloPage(ModelAndView model){
        model.setViewName("hello");
        return model;
    }
}
