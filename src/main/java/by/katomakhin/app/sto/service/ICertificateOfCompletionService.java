package by.katomakhin.app.sto.service;

import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.utils.CerUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface ICertificateOfCompletionService {
    void createCertificateOfCompletion (String carModel, String licensePlate, List<PointOfCertificate> points);

    CertificateOfCompletion getCertificateOfCompletion (String licensePlate);

    List<CertificateOfCompletion> getCompleteCertificateOfCompletion (String carModel, String licensePlate);

    boolean updateCertificateOfCompletion(CarInfo carInfo, CertificateOfCompletion certificate);

    boolean closeCertificateOfCompletion(CarInfo carInfo);

    List<CertificateOfCompletion> getCompleteCertificateOfCompletion(CarInfo carInfo);
}
