
package Midterm;

import javax.swing.JOptionPane;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Patient {
    private String name;
    private String symptoms;
    private String doctor;

    public Patient(String name, String symptoms, String doctor) {
        this.name = name;
        this.symptoms = symptoms;
        this.doctor = doctor;
    }

    public String getName() { return name; }
    public String getSymptoms() { return symptoms; }
    public String getDoctor() { return doctor; }

    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    
    public String toString() {
        return "Name: " + name + "\nSymptoms: " + symptoms + "\nDoctor: " + doctor + "\n";
    }
}

public class ClinicPatientManagement_System {
    
    private Queue<Patient> patientQueue = new LinkedList<>();
    private Map<String, Integer> doctorMap = new HashMap<>();

    // Add a patient
    public void addPatient(String name, String symptoms, String doctor) {
        Patient newPatient = new Patient(name, symptoms, doctor);
        patientQueue.add(newPatient);
        doctorMap.put(doctor, doctorMap.getOrDefault(doctor, 0) + 1);
        JOptionPane.showMessageDialog(null, "Patient added successfully!");
    }

    // View all patients
    public void viewPatients() {
        if (patientQueue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No patients in the queue.");
            return;
        }

        StringBuilder data = new StringBuilder("Current Patients:\n\n");
        for (Patient p : patientQueue) {
            data.append(p.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, data.toString());
    }

    // Update patient
    public void updatePatient(String name, String newSymptoms, String newDoctor) {
        boolean found = false;

        for (Patient p : patientQueue) {
            if (p.getName().equalsIgnoreCase(name)) {
                doctorMap.put(p.getDoctor(), doctorMap.get(p.getDoctor()) - 1);
                if (doctorMap.get(p.getDoctor()) <= 0) doctorMap.remove(p.getDoctor());

                p.setSymptoms(newSymptoms);
                p.setDoctor(newDoctor);

                doctorMap.put(newDoctor, doctorMap.getOrDefault(newDoctor, 0) + 1);

                JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Patient not found.");
        }
    }

    // Serve next patient
    public void serveNextPatient() {
        if (patientQueue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No patients to serve.");
            return;
        }

        Patient served = patientQueue.poll();
        doctorMap.put(served.getDoctor(), doctorMap.get(served.getDoctor()) - 1);
        if (doctorMap.get(served.getDoctor()) <= 0) doctorMap.remove(served.getDoctor());

        JOptionPane.showMessageDialog(null, "Served patient: " + served.getName());
    }

    // View doctor-patient count
    public void viewDoctors() {
        if (doctorMap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No doctor assignments.");
            return;
        }

        StringBuilder info = new StringBuilder("Doctor Assignments:\n\n");

        for (String doctor : doctorMap.keySet()) {
            info.append("Dr. ").append(doctor)
                .append(" has ")
                .append(doctorMap.get(doctor))
                .append(" patient(s).\n");
        }

        JOptionPane.showMessageDialog(null, info.toString());
    }

    // Main program (JOptionPane Menu)
    public static void main(String[] args) {
        ClinicPatientManagement_System clinic = new ClinicPatientManagement_System();
        String[] options = {
                "Add Patient",
                "View Patients",
                "Update Patient",
                "Serve Next Patient",
                "View Doctors",
                "Exit"
        };

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "CLINIC PATIENT MANAGEMENT SYSTEM",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 5 || choice == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Exiting system... Thank you!");
                break;
            }

            switch (choice) {
                case 0: // Add
                    String name = JOptionPane.showInputDialog("Enter patient name:");
                    String symptoms = JOptionPane.showInputDialog("Enter symptoms:");
                    String doctor = JOptionPane.showInputDialog("Enter assigned doctor:");
                    clinic.addPatient(name, symptoms, doctor);
                    break;

                case 1: // View
                    clinic.viewPatients();
                    break;

                case 2: // Update
                    String updateName = JOptionPane.showInputDialog("Enter patient name to update:");
                    String newSymptoms = JOptionPane.showInputDialog("Enter new symptoms:");
                    String newDoctor = JOptionPane.showInputDialog("Enter new doctor:");
                    clinic.updatePatient(updateName, newSymptoms, newDoctor);
                    break;

                case 3: // Serve
                    clinic.serveNextPatient();
                    break;

                case 4: // View doctors
                    clinic.viewDoctors();
                    break;
            }
        }
    }
    
}