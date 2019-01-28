package by.katomakhin.app.sto.dao.point;

import by.katomakhin.app.sto.model.car.CarModel;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;

import java.util.List;

public interface IPointRepository {
    PointOfCertificate getPoint(String name, CarModel carModel);
    PointOfCertificate getPoint (int id);
    List<PointOfCertificate> getPointsByModel (CarModel carModel);
    int createPoint (CarModel carModel,PointOfCertificate pointOfCertificate);
    int updatePoint (CarModel carModel, int id, PointOfCertificate pointOfCertificate);
    boolean deletePoint (int id);
}
