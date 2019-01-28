package by.katomakhin.app.sto.service.dev;

import by.katomakhin.app.sto.dao.point.IPointRepository;
import by.katomakhin.app.sto.model.car.CarModel;
import by.katomakhin.app.sto.model.certificate.PointOfCertificate;
import by.katomakhin.app.sto.service.IPointService;
import by.katomakhin.app.sto.utils.CerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PointsService implements IPointService {
    private IPointRepository pointRepository;

    @Autowired
    public PointsService(IPointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }


    public PointOfCertificate getPointByName(String name, String modelName){
        return pointRepository.getPoint(name, CerUtils.getCarModelByName(modelName));
    }

    public int createPoint(String modelName, double price, String pointName){
        return pointRepository.createPoint(CerUtils.getCarModelByName(modelName),
                new PointOfCertificate(new BigDecimal(price), pointName));
    }

    public PointOfCertificate getPoint(int id) {
       return pointRepository.getPoint(id);
    }

    public List<PointOfCertificate> getPointsByModel(String modelName) {
        return pointRepository.getPointsByModel(CerUtils.getCarModelByName(modelName));
    }

    public int updatePoint(String modelName, int id, double price, String name) {
        return pointRepository.updatePoint(CerUtils.getCarModelByName(modelName), id,
                new PointOfCertificate(new BigDecimal(price), name));
    }

    public boolean deletePoint(int id) {
        return pointRepository.deletePoint(id);
    }

}
