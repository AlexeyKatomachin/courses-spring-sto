package by.katomakhin.app.sto.service.demo;

import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.IPointService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class DemoPointService implements IPointService {
    @Override
    public PointOfCertificate getPointByName(String name, String modelName) {
        return new PointOfCertificate(new BigDecimal(10.0), name);
    }

    @Override
    public int createPoint(String modelName, double price, String pointName) {
        return new PointOfCertificate(new BigDecimal(price), pointName).hashCode();
    }

    @Override
    public PointOfCertificate getPoint(int id) {
        return new PointOfCertificate(new BigDecimal(15.0), "Demo work");
    }

    @Override
    public List<PointOfCertificate> getPointsByModel(String modelName) {
        return Arrays.asList(new PointOfCertificate(new BigDecimal(17.0), "Demo work 1"),
                new PointOfCertificate(new BigDecimal(16.0), "Demo work 2"));
    }

    @Override
    public int updatePoint(String modelName, int id, double price, String name) {
        return new PointOfCertificate(new BigDecimal(price), name).hashCode();
    }

    @Override
    public boolean deletePoint(int id) {
        return true;
    }
}
