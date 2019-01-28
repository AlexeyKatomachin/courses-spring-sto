package by.katomakhin.app.sto.model.car;

public enum CarModel {
    AUDI("audi"),
    BMW("bmv"),
    MERCEDES("mercedes"),
    PORSCHE("porsche");

    private String name;

    CarModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
