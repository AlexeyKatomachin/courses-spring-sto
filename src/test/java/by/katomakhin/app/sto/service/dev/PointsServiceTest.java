package by.katomakhin.app.sto.service.dev;

import by.katomakhin.app.sto.conf.ApplicationConfig;
import by.katomakhin.app.sto.conf.RootConfig;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.IPointService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, RootConfig.class})
@ActiveProfiles("dev")
public class PointsServiceTest {

    @Autowired
    private IPointService pointsService;


    @Test
    public void getPointByName() {
        PointOfCertificate pointByName = pointsService.getPointByName("Oil", "bmw");
        assertNotNull(pointByName);
    }

    @Test
    public void createPoint() {
        int pointId = pointsService.createPoint("bmw", 10.5, "Computer Diagnostic");
        assertNotNull(pointId);
    }
    @Test
    public void getPoint() {
        PointOfCertificate point = pointsService.getPoint(pointsService.getPointByName("superOil", "bmw").getId());
        assertNotNull(point);
    }

    @Test
    public void getPointsByModel() {
        List<PointOfCertificate> bmw = pointsService.getPointsByModel("bmw");
        assertNotNull(bmw);
    }

    @Test
    public void updatePoint() {
        PointOfCertificate pointByName = pointsService.getPointByName("Oil", "bmw");
        int id = pointsService.updatePoint("bmw", pointByName.getId(), 20.5, "superOil");
        assertEquals("superOil", pointsService.getPoint(id).getName());
    }

    @Test
    public void deletePoint() {
        PointOfCertificate pointByName = pointsService.getPointByName("Change of oil", "bmw");
        pointsService.deletePoint(pointByName.getId());
        PointOfCertificate pointOfCertificate = pointsService.getPointsByModel("bmw").stream()
                .filter(x -> x.getName().equals("Change of oil"))
                .findFirst()
                .orElse(null);
        assertNull(pointOfCertificate);
    }
}