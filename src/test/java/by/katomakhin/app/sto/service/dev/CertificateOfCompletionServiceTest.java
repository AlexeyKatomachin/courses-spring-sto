package by.katomakhin.app.sto.service.dev;

import by.katomakhin.app.sto.conf.ApplicationConfig;
import by.katomakhin.app.sto.dao.certificate.ICertRepository;
import by.katomakhin.app.sto.dao.point.IPointRepository;
import by.katomakhin.app.sto.model.car.CarInfo;
import by.katomakhin.app.sto.model.car.CarModel;
import by.katomakhin.app.sto.model.certificate.CertificateOfCompletion;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.ICertificateOfCompletionService;
import by.katomakhin.app.sto.service.IPointService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("dev")
public class CertificateOfCompletionServiceTest {
    @Autowired
    private ApplicationConfig config;
    private ICertificateOfCompletionService certRepository;
    private IPointService pointRepository;

    @Before
    public void init() {
        this.certRepository = config.getCertModel();
        this.pointRepository = config.getPointModel();
    }

    @Test
    public void createCertificateOfCompletion() {
        certRepository.createCertificateOfCompletion("bmw", "3367 EM-7", getListPoints());
    }

    @Test
    public void getCertificateOfCompletion() {
        CertificateOfCompletion certificateOfCompletion = certRepository.getCertificateOfCompletion("6578 FK-5");
        assertNotNull(certificateOfCompletion);
    }

    @Test
    public void getCompleteCertificateOfCompletion() {
        List<CertificateOfCompletion> completion = certRepository.getCompleteCertificateOfCompletion("bmw",
                "6578 FK-5");
        assertNotNull(completion);
    }

    @Test
    public void updateCertificateOfCompletion() {
        boolean isUpdate = certRepository.updateCertificateOfCompletion(new CarInfo(CarModel.BMW, "6578 FK-5"),
                new CertificateOfCompletion(getListPoints(), new BigDecimal(86.6)));
        assertTrue(isUpdate);
    }

    @Test
    public void closeCertificateOfCompletion() {
    }

    private List<PointOfCertificate> getListPoints() {
        return Arrays.asList(
                new PointOfCertificate(new BigDecimal(10.4), "Oil", 4),
                new PointOfCertificate(new BigDecimal(20.0), "Change of oil", 1),
                new PointOfCertificate(new BigDecimal(12.0), "Air filter", 2),
                new PointOfCertificate(new BigDecimal(13.0), "Change air filter", 1));
    }
}