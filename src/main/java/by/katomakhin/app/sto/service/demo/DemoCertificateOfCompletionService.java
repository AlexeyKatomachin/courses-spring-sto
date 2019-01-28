package by.katomakhin.app.sto.service.demo;

import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.ICertificateOfCompletionService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DemoCertificateOfCompletionService implements ICertificateOfCompletionService {
    @Override
    public void createCertificateOfCompletion(String carModel, String licensePlate, List<PointOfCertificate> points) {

    }

    @Override
    public CertificateOfCompletion getCertificateOfCompletion(String licensePlate) {
        return new CertificateOfCompletion(Arrays.asList(
                new PointOfCertificate(new BigDecimal(10.4), "Demo work 1"),
                new PointOfCertificate(new BigDecimal(20.0), "Demo work 2")),
                new BigDecimal(30.4));
    }

    @Override
    public List<CertificateOfCompletion> getCompleteCertificateOfCompletion(String carModel, String licensePlate) {
        return Arrays.asList(
                new CertificateOfCompletion(Arrays.asList(
                    new PointOfCertificate(new BigDecimal(10.4), "Demo work 1"),
                    new PointOfCertificate(new BigDecimal(20.0), "Demo work 2")),
                    new BigDecimal(30.4)),
                new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(15.4), "Demo work 3"),
                        new PointOfCertificate(new BigDecimal(25.0), "Demo work 4")),
                        new BigDecimal(40.4)));
    }

    @Override
    public boolean updateCertificateOfCompletion(CarInfo carInfo, CertificateOfCompletion certificate) {
        return true;
    }

    @Override
    public boolean closeCertificateOfCompletion(CarInfo carInfo) {
        return true;
    }

    @Override
    public List<CertificateOfCompletion> getCompleteCertificateOfCompletion(CarInfo carInfo) {
        return Arrays.asList(
                new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(10.4), "Demo work 5"),
                        new PointOfCertificate(new BigDecimal(20.0), "Demo work 6")),
                        new BigDecimal(30.4)),
                new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(15.4), "Demo work 7"),
                        new PointOfCertificate(new BigDecimal(25.0), "Demo work 8")),
                        new BigDecimal(40.4)));
    }
}
