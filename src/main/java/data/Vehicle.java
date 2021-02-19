package data;

import java.io.Serial;
import java.io.Serializable;

public class Vehicle implements Serializable {
    private final Type type;
    private final String brand;
    private final String model;
    private final int productionYear;
    private final int mileage;
    private final String vin;
    @Serial
    private static final long serialVersionUID = 1L;

    public Vehicle(Type type, String brand, String model, int productionYear, int mileage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type=" + type +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                '}';
    }
}
