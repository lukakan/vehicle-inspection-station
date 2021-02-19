package utils;

import data.Type;
import data.Vehicle;

import java.util.Scanner;

public class VehicleCreator {

    public Vehicle create() {
        Scanner scanner = new Scanner(System.in);
        displayOptions();
        int input = scanner.nextInt();
        Type type = defineType(input);
        scanner.nextLine();
        System.out.println("Podaj marke");
        String brand = scanner.nextLine();
        System.out.println("Podaj model");
        String model = scanner.nextLine();
        System.out.println("Podaj rok produkcji");
        int productionYear = scanner.nextInt();
        System.out.println("Podaj przebieg");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj vin");
        String vin = scanner.nextLine();
        return new Vehicle(type, brand, model, productionYear, mileage, vin);
    }

    private void displayOptions() {
        System.out.println("Podaj typ");
        System.out.println(0 + " " + Type.CAR.getDescription());
        System.out.println(1 + " " + Type.MOTOR.getDescription());
        System.out.println(2 + " " + Type.TRUCK.getDescription());
    }

    private Type defineType(int input) {
        switch (input) {
            case 0:
                return Type.CAR;
            case 1:
                return Type.MOTOR;
            case 2:
                return Type.TRUCK;
            default:
                return null;
        }

    }
}
