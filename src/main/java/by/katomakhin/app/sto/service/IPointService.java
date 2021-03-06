package by.katomakhin.app.sto.service;

import by.katomakhin.app.sto.model.certificate.PointOfCertificate;

import java.util.List;

public interface IPointService {
    PointOfCertificate getPointByName(String name, String modelName);

    int createPoint(String modelName, double price, String pointName);

    PointOfCertificate getPoint(int id);

    List<PointOfCertificate> getPointsByModel(String modelName);

    int updatePoint(String modelName, int id, double price, String name);

    boolean deletePoint(int id);
}
