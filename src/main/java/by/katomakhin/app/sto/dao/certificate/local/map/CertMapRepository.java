package by.katomakhin.app.sto.dao.certificate.local.map;

import by.katomakhin.app.sto.dao.certificate.ICertRepository;
import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.car.CarModel;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CertMapRepository implements ICertRepository {
    private static final Map<CarInfo, CertificateOfCompletion> carCertificate = new HashMap<>();
    private static final Map<CarInfo, List<CertificateOfCompletion>> closedCarCertificate = new HashMap<>();

    public CertMapRepository() {
        if (carCertificate.isEmpty()){
            init();
        }
    }

    public CertificateOfCompletion getCertificateOfCompletion(CarInfo carInfo) {
        return carCertificate.get(carInfo);
    }

    @Override
    public CertificateOfCompletion getCertificateOfCompletion(String licensePlate) {
        CarInfo carInfo = carCertificate.keySet().stream()
                .filter(x -> x.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
        if (carInfo == null){
            return new CertificateOfCompletion();
        }
        return carCertificate.get(carInfo);
    }

    public boolean createCertificateOfCompletion(CarInfo carInfo, CertificateOfCompletion certificate) {
        CertificateOfCompletion closeCertificate = carCertificate.put(carInfo, certificate);
        putClosedCertificate(carInfo, closeCertificate);
        return true;
    }

    public boolean updateCertificateOfCompletion(CarInfo carInfo, CertificateOfCompletion certificate) {
        CarInfo createdCarInfo  = carCertificate.keySet().stream().filter(x -> x.equals(carInfo)).findFirst().orElse(carInfo);
        carCertificate.put(createdCarInfo, certificate);
        return true;
    }

    public boolean closeCertificateOfCompletion(CarInfo carInfo) {
        CertificateOfCompletion certificate = carCertificate.get(carInfo);
        putClosedCertificate(carInfo, certificate);
        carCertificate.remove(carInfo);
        return true;
    }

    public List<CertificateOfCompletion> getCompleteCertificateOfCompletion(CarInfo carInfo) {
        CarInfo closedCarInfo = closedCarCertificate.keySet().stream()
                .filter(x -> x.equals(carInfo))
                .findFirst()
                .orElse(null);
        return closedCarCertificate.get(closedCarInfo);
    }

    private void putClosedCertificate(CarInfo carInfo, CertificateOfCompletion certificate){
        List<CertificateOfCompletion> certificateList = closedCarCertificate.get(carInfo);
        if (certificateList == null || certificateList.isEmpty()){
            closedCarCertificate.put(carInfo, Arrays.asList(certificate));
        } else {
            certificateList.add(certificate);
        }
    }

    private void init(){
        carCertificate.put(
                new CarInfo(CarModel.AUDI, "3345 MP-7"),
                new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(10.4), "Oil", 5),
                        new PointOfCertificate(new BigDecimal(20.0), "Change of oil", 1),
                        new PointOfCertificate(new BigDecimal(12.0), "Air filter", 1),
                        new PointOfCertificate(new BigDecimal(13.0), "Change air filter", 1)
                ), new BigDecimal(97.4))
        );
        carCertificate.put(
                new CarInfo(CarModel.BMW, "6578 FK-5"),
                new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(12.4), "Oil", 5),
                        new PointOfCertificate(new BigDecimal(18.0), "Change of oil", 1),
                        new PointOfCertificate(new BigDecimal(10.0), "Air filter", 1),
                        new PointOfCertificate(new BigDecimal(11.0), "Change air filter", 1)
                ), new BigDecimal(101.0))
        );
        closedCarCertificate.put(
                new CarInfo(CarModel.BMW, "6578 FK-5"),
                Arrays.asList(new CertificateOfCompletion(Arrays.asList(
                        new PointOfCertificate(new BigDecimal(12.4), "Oil", 4),
                        new PointOfCertificate(new BigDecimal(18.0), "Change of oil", 1),
                        new PointOfCertificate(new BigDecimal(10.0), "Air filter", 1),
                        new PointOfCertificate(new BigDecimal(11.0), "Change air filter", 1)
                ), new BigDecimal(87.6)))
        );
    }
}
