package by.katomakhin.app.sto.dao.point.locale.map;

import by.katomakhin.app.sto.dao.point.IPointRepository;
import by.katomakhin.app.sto.model.car.CarModel;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;

import java.math.BigDecimal;
import java.util.*;

public class PointMapRepository implements IPointRepository {
    private final static Map<CarModel, List<PointOfCertificate>> pointsMap = new HashMap<>();

    public PointMapRepository() {
        if (pointsMap.isEmpty()){
            init();
        }
    }

    public PointOfCertificate getPoint(String name, CarModel carModel) {
        return pointsMap.get(carModel).stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PointOfCertificate getPoint(int id) {
        return pointsMap.values().stream()
                .filter(ar -> {
                    PointOfCertificate point = ar.stream()
                            .filter(x -> x.getId() == id)
                            .findFirst()
                            .orElse(null);
                    if (point == null){
                        return false;
                    } else {
                        return true;
                    }
                })
                .findFirst()
                .orElse(new ArrayList<>())
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(new PointOfCertificate());
    }

    public List<PointOfCertificate> getPointsByModel(CarModel carModel) {
        return pointsMap.get(carModel);
    }

    public int createPoint(CarModel carModel, PointOfCertificate pointOfCertificate) {
        List<PointOfCertificate> pointOfCertificates = pointsMap.get(carModel);
        List<PointOfCertificate> newPointsOfCertificates = new ArrayList<>(pointOfCertificates);
        newPointsOfCertificates.add(pointOfCertificate);
        pointsMap.put(carModel, newPointsOfCertificates);
        return pointOfCertificate.getId();
    }

    public int updatePoint(CarModel carModel, int id, PointOfCertificate pointOfCertificate) {
        List<PointOfCertificate> pointOfCertificates = pointsMap.get(carModel);
        if (pointOfCertificates.isEmpty()){
            return createPoint(carModel, pointOfCertificate);
        }
        PointOfCertificate pointOfCertificateOld = pointOfCertificates.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(pointOfCertificate);
        pointOfCertificateOld.setName(pointOfCertificate.getName());
        pointOfCertificateOld.setPrice(pointOfCertificate.getPrice());
        return pointOfCertificateOld.getId();
    }

    public boolean deletePoint(int id) {
        Map.Entry<CarModel, List<PointOfCertificate>> modelEntry = pointsMap.entrySet().stream()
                .filter(x -> getPointById(id, x.getValue()) != null)
                .findFirst()
                .orElse(null);
        if (modelEntry != null) {
            ArrayList<PointOfCertificate> pointOfCertificates = new ArrayList<>(modelEntry.getValue());
            pointOfCertificates.removeIf(x -> x.getId() == id);
            pointsMap.put(modelEntry.getKey(), pointOfCertificates);
            return true;
        }
        return false;
    }

    private PointOfCertificate getPointById(int id, List<PointOfCertificate> points){
         return points.stream()
                 .filter(x -> x.getId() == id)
                 .findFirst()
                 .orElse(null);
    }

    private void init(){
        pointsMap.put(CarModel.AUDI, Arrays.asList(
                new PointOfCertificate(new BigDecimal(10.4), "Oil"),
                new PointOfCertificate(new BigDecimal(20.0), "Change of oil")));
        pointsMap.put(CarModel.BMW, Arrays.asList(
                new PointOfCertificate(new BigDecimal(14.0), "Oil"),
                new PointOfCertificate(new BigDecimal(24.0), "Change of oil")));
        pointsMap.put(CarModel.MERCEDES, Arrays.asList(
                new PointOfCertificate(new BigDecimal(13.2), "Oil"),
                new PointOfCertificate(new BigDecimal(26.0), "Change of oil")));
        pointsMap.put(CarModel.PORSCHE, Arrays.asList(
                new PointOfCertificate(new BigDecimal(16.7), "Oil"),
                new PointOfCertificate(new BigDecimal(31.0), "Change of oil")));
    }


}
