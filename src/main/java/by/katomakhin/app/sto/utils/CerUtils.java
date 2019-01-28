package by.katomakhin.app.sto.utils;


import by.katomakhin.app.sto.model.car.CarModel;

public class CerUtils {
    public static CarModel getCarModelByName(String name){
        switch (name){
            case "bmw":
                return CarModel.BMW;
            case  "audi":
                return CarModel.AUDI;
            case "mercedes":
                return CarModel.MERCEDES;
            case "porsche":
                return CarModel.PORSCHE;
            default:
                return null;
        }
    }
}
