package by.katomakhin.app.sto.dao.certificate;

import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;

import java.util.List;

public interface ICertRepository {
    CertificateOfCompletion getCertificateOfCompletion(CarInfo carInfo);
    CertificateOfCompletion getCertificateOfCompletion(String licensePlate);
    boolean createCertificateOfCompletion (CarInfo carInfo, CertificateOfCompletion certificate);
    boolean updateCertificateOfCompletion (CarInfo carInfo, CertificateOfCompletion certificate);
    boolean closeCertificateOfCompletion (CarInfo carInfo);
    List<CertificateOfCompletion> getCompleteCertificateOfCompletion (CarInfo carInfo);
}
