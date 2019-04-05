package aop.spring.instruments;

public class BuilderInstruments implements Intruments {
    @Override
    public void repair() {
        System.out.println("Fixing building issues");
    }
}
