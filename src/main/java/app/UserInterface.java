package app;

import data.Vehicle;
import utils.QueueToFileUtils;
import utils.VehicleCreator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UserInterface {
    private static final int EXIT = 0;
    private static final int NEW_VEHICLE = 1;
    private static final int INSPECT_VEHICLE = 2;
    private static final int DISPLAY_VEHICLES = 3;
    private final VehicleCreator vehicleCreator;
    private final QueueToFileUtils queueUtils;
    private final Queue<Vehicle> queue;

    public UserInterface() {
        vehicleCreator = new VehicleCreator();
        queueUtils = new QueueToFileUtils();
        if (queueUtils.isFileEmpty()) {
            queue = new LinkedList<>();
        } else {
            queue = queueUtils.read();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            displayMenu();
            userChoice = scanner.nextInt();
            scanner.nextLine();
            implementUserChoice(userChoice);
        } while (userChoice != EXIT);
    }

    private void implementUserChoice(int userChoice) {
        switch (userChoice) {
            case NEW_VEHICLE:
                queue.add(vehicleCreator.create());
                break;
            case INSPECT_VEHICLE:
                inspectCar();
                break;
            case EXIT:
                saveQueue();
                break;
            case DISPLAY_VEHICLES:
                System.out.println(queue);
                break;
            default:
                System.out.println("Niepoprawna komenda, spróbuj ponownie");
        }
    }

    private void inspectCar() {
        if (queue.isEmpty()) {
            System.out.println("brak pojazdow w kolejce");
        } else {
            System.out.println("Inspekcja na pojeździe");
            System.out.println(queue.peek());
            queue.poll();
        }
    }

    private void saveQueue() {
        if (!queue.isEmpty()) {
            queueUtils.save(queue);
        }
    }

    private void displayMenu() {
        System.out.println("Dostępne opcje: ");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(NEW_VEHICLE + " - dodaj pojazd do kolejki");
        System.out.println(INSPECT_VEHICLE + " - obsłuż pojazd");
        System.out.println(DISPLAY_VEHICLES + " - wyświetl pojazdy w kolejce");
    }


}
