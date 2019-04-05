package aop.spring.instruments.support;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class InstrumentCleaner {

    @After("execution(* *.repair())")
    public void cleanBuilderInstruments(){
        System.out.println("Instruments are cleared");
    }

//    @After("execution(* PlumberInstruments.repair())")
//    public void cleanPlumberInstruments(){
//        System.out.println("PlumberInstruments are cleared");
//    }
}
