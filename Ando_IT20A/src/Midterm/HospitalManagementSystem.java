package Midterm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalManagementSystem {

    public static void main(String[] args) {
        Queue<Patient> arrivalQueue = new LinkedList<>();
        PriorityQueue<Patient> treatmentQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.severity));

        arrivalQueue.add(new Patient("Anna", 3));
        arrivalQueue.add(new Patient("Bob", 1));
        arrivalQueue.add(new Patient("Carla", 2));
        arrivalQueue.add(new Patient("Dave", 1));

        treatmentQueue.addAll(arrivalQueue);

        System.out.println("=== Arrival Order ===");
        System.out.println("Arrival Order: " + arrivalQueue);

        System.out.println("\n=== Treatment Order ===");
        while (!treatmentQueue.isEmpty()) {
            Patient p = treatmentQueue.poll();
            System.out.println("Treating: " + p);
        }
    }
}
