package by.katomakhin.app.sto.model.car;

public class CarInfo {
    private CarModel model;
    private String licensePlate;

    public CarInfo(CarModel model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public CarInfo() {
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarInfo){
            CarInfo carInfo = (CarInfo) obj;
            return this.licensePlate.equals(carInfo.getLicensePlate()) && this.model.equals(carInfo.model);
        }
        return false;
    }
}
