package by.katomakhin.app.sto.service.dev;

import by.katomakhin.app.sto.dao.certificate.ICertRepository;
import by.katomakhin.app.sto.dao.point.IPointRepository;
import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.ICertificateOfCompletionService;
import by.katomakhin.app.sto.utils.CerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateOfCompletionService implements ICertificateOfCompletionService {
    private ICertRepository certRepository;

    @Autowired
    public CertificateOfCompletionService(ICertRepository certRepository) {
        this.certRepository = certRepository;
    }

    @Bean
    public void createCertificateOfCompletion (String carModel, String licensePlate, List<PointOfCertificate> points){
        CarInfo carInfo = new CarInfo(CerUtils.getCarModelByName(carModel), licensePlate);
        CertificateOfCompletion certificateOfCompletion = new CertificateOfCompletion();
        points.forEach(x -> {
            certificateOfCompletion.getPoints().add(x);
            certificateOfCompletion.setTotalAmount(
                    certificateOfCompletion.getTotalAmount()
                            .add(x.getPrice()
                                    .multiply(new BigDecimal(x.getCount())
                                    )
                            )
            );
        });
        certRepository.createCertificateOfCompletion(carInfo, certificateOfCompletion);
    }

    @Bean
    public CertificateOfCompletion getCertificateOfCompletion (String licensePlate){
        return certRepository.getCertificateOfCompletion(licensePlate);
    }

    @Bean
    public List<CertificateOfCompletion> getCompleteCertificateOfCompletion (String carModel, String licensePlate){
        return certRepository.getCompleteCertificateOfCompletion(new CarInfo(CerUtils.getCarModelByName(carModel), licensePlate));
    }

    public boolean updateCertificateOfCompletion(CarInfo carInfo, CertificateOfCompletion certificate) {
        return certRepository.updateCertificateOfCompletion(carInfo, certificate);
    }

    public boolean closeCertificateOfCompletion(CarInfo carInfo) {
        return certRepository.closeCertificateOfCompletion(carInfo);
    }

    public List<CertificateOfCompletion> getCompleteCertificateOfCompletion(CarInfo carInfo) {
        return certRepository.getCompleteCertificateOfCompletion(carInfo);
    }
}
