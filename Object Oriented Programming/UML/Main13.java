/*
                             +--------------------+
                             |      Person        |
                             +--------------------+
                             | - id: String        |
                             | - name: String      |
                             | - birthDate: Date   |
                             | - address: String   |
                             +--------------------+
                             | + getDetails(): String |
                             +--------------------+
                                      ^  
                                      |
            +--------------------------+---------------------+
            |                                               |
     +-------------------+                           +-------------------+
     |      Doctor       |                           |      Patient      |
     +-------------------+                           +-------------------+
     | - doctorId: String|                           | - patientId: String|
     | - specialty: String|                           | - diagnosis: String|
     +-------------------+                           +-------------------+
     | + treatPatient(): void|                         | + requestAppointment(): void |
     | + getDetails(): String|                         | + getDetails(): String |
     +-------------------+                           +-------------------+
            ^                                               ^
            |                                               |
      +-----------------+                           +--------------------+
      |   Appointment   |                           |    Department      |
      +-----------------+                           +--------------------+
      | - appointmentId: String |                   | - departmentId: String |
      | - date: Date            |                   | - departmentName: String |
      | - patient: Patient      |                   +------------------------+
      | - doctor: Doctor        |                   | + assignDoctor(doctor: Doctor): void |
      +-------------------------+                   | + getDetails(): String |
      | + schedule(): void      |                   +------------------------+
      +-------------------------+

*/
import java.util.*;

// Person class
class Person {
    private String id;
    private String name;
    private Date birthDate;
    private String address;

    public Person(String id, String name, Date birthDate, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Birth Date: " + birthDate + ", Address: " + address;
    }
}

// Doctor class
class Doctor extends Person {
    private String doctorId;
    private String specialty;

    public Doctor(String id, String name, Date birthDate, String address, String doctorId, String specialty) {
        super(id, name, birthDate, address);
        this.doctorId = doctorId;
        this.specialty = specialty;
    }

    public void treatPatient() {
        System.out.println(name + " is treating a patient.");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Doctor ID: " + doctorId + ", Specialty: " + specialty;
    }
}

// Patient class
class Patient extends Person {
    private String patientId;
    private String diagnosis;

    public Patient(String id, String name, Date birthDate, String address, String patientId, String diagnosis) {
        super(id, name, birthDate, address);
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    public void requestAppointment() {
        System.out.println(name + " has requested an appointment.");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Patient ID: " + patientId + ", Diagnosis: " + diagnosis;
    }
}

// Appointment class
class Appointment {
    private String appointmentId;
    private Date date;
    private Patient patient;
    private Doctor doctor;

    public Appointment(String appointmentId, Date date, Patient patient, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public void schedule() {
        System.out.println("Appointment scheduled for " + patient.getDetails() + " with " + doctor.getDetails() + " on " + date);
    }
}

// Department class
class Department {
    private String departmentId;
    private String departmentName;
    private List<Doctor> doctors;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctors = new ArrayList<>();
    }

    public void assignDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println(doctor.getDetails() + " has been assigned to the " + departmentName + " department.");
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Department ID: " + departmentId + ", Department Name: " + departmentName);
        details.append("\nDoctors: \n");
        for (Doctor doctor : doctors) {
            details.append(doctor.getDetails() + "\n");
        }
        return details.toString();
    }
}

// Main class to test the functionality
public class Main13 {
    public static void main(String[] args) {
        // Create some doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Smith", new Date(), "123 Clinic St", "D001", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Johnson", new Date(), "124 Clinic St", "D002", "Neurology");

        // Create some patients
        Patient patient1 = new Patient("P001", "Alice", new Date(), "456 Main St", "P001", "Heart Disease");
        Patient patient2 = new Patient("P002", "Bob", new Date(), "457 Main St", "P002", "Migraine");

        // Create an appointment
        Appointment appointment1 = new Appointment("A001", new Date(), patient1, doctor1);

        // Create a department
        Department cardiology = new Department("DEP001", "Cardiology");

        // Assign doctors to departments
        cardiology.assignDoctor(doctor1);
        cardiology.assignDoctor(doctor2);

        // Request an appointment
        patient1.requestAppointment();
        patient2.requestAppointment();

        // Schedule the appointment
        appointment1.schedule();

        // Display department details
        System.out.println(cardiology.getDetails());
    }
}
