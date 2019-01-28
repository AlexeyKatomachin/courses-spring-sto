package by.katomakhin.app.sto.model.certificate;

import java.math.BigDecimal;

public class PointOfCertificate {
    private int id;
    private BigDecimal price;
    private String name;
    private int count;

    public PointOfCertificate(BigDecimal price, String name, int count) {
        this.id = hashCode();
        this.price = price;
        this.name = name;
        this.count = count;
    }

    public PointOfCertificate(BigDecimal price, String name) {
        this.id = hashCode();
        this.price = price;
        this.name = name;
        this.count = 0;
    }

    public PointOfCertificate() {
        this.id = hashCode();
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
