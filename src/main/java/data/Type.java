package data;

public enum Type {
    MOTOR("motocykl"), CAR("samochód osobowy"), TRUCK("ciężarówka");

    String description;
    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
