package utils;

import data.Vehicle;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueToFileUtils {
    public static final String FILE_PATH = "queue.txt";

    public void save(Queue<Vehicle> vehicles) {
        try (
                var fileOutputStream = new FileOutputStream(FILE_PATH);
                var objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            while (!vehicles.isEmpty()) {
                Vehicle vehicleToSave = vehicles.poll();
                objectOutputStream.writeObject(vehicleToSave);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queue<Vehicle> read() {

        Vehicle vehicle;
        Queue<Vehicle> vehicles = new LinkedList<>();
        try (
                var fileInputStream = new FileInputStream(FILE_PATH);
                var objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            while ((vehicle = (Vehicle) objectInputStream.readObject()) != null) {
                vehicles.offer(vehicle);
            }

        } catch (EOFException e) {
            System.out.println("data loaded");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public boolean isFileEmpty() {
        File file = new File(FILE_PATH);
        return file.length() == 0;
    }


}
