package aop.spring.instruments;

public class PlumberInstruments implements Intruments {
    @Override
    public void repair() {
        System.out.println("Fixing plumbing issues");
    }
}
