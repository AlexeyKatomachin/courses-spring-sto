package aop.spring.helper;

import aop.spring.instruments.Intruments;

public class HouseHelper {
    private final Intruments instruments;

    public HouseHelper(Intruments instruments){
        this.instruments = instruments;
    }

    public void fixBuilding(){
        System.out.println("Start fixing house issues");
        instruments.repair();
        System.out.println("Finished fixing house issues");
    }
}
