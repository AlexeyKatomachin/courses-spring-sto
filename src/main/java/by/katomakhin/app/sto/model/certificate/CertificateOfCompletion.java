package by.katomakhin.app.sto.model.certificate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CertificateOfCompletion {
    private int id;
    private List<PointOfCertificate> points;
    private BigDecimal totalAmount;

    public CertificateOfCompletion(List<PointOfCertificate> points, BigDecimal totalAmount) {
        this.points = points;
        this.totalAmount = totalAmount;
        this.id = this.hashCode();
    }

    public CertificateOfCompletion() {
        this.id = this.hashCode();
        this.totalAmount = new BigDecimal(0);
    }

    public int getId() {
        return id;
    }

    public List<PointOfCertificate> getPoints() {
        if (points == null){
            points = new ArrayList<PointOfCertificate>();
        }
        return points;
    }

    public void setPoints(List<PointOfCertificate> points) {
        this.points = points;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
