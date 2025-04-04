import java.util.*;

class User {
    String name;
    String email;
    String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

class Appointment {
    String doctorName;
    String date;
    String time;
    String userEmail;

    Appointment(String doctorName, String date, String time, String userEmail) {
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.userEmail = userEmail;
    }
}

class SymptomChecker {
    public String getSuggestion(String symptom) {
        if (symptom.toLowerCase().contains("fever")) {
            return "Possible flu or infection. Stay hydrated and consult a doctor.";
        } else if (symptom.toLowerCase().contains("headache")) {
            return "Could be stress or migraine. Rest and monitor your symptoms.";
        } else if (symptom.toLowerCase().contains("cough")) {
            return "Dry cough detected. Consider seeing a doctor if it persists.";
        } else {
            return "Symptom not recognized. Please consult a healthcare provider.";
        }
    }
}
class HealthCareApp {

    static Scanner scanner = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static SymptomChecker symptomChecker = new SymptomChecker();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Smart Healthcare Virtual Assistant ====");
            System.out.println("1. Register");
            System.out.println("2. Check Symptoms");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    checkSymptoms();
                    break;
                case 3:
                    bookAppointment();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    System.out.println("Thank you for using the virtual health assistant!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(name, email, password));
        System.out.println("User registered successfully.");
    }

    static void checkSymptoms() {
        System.out.print("Enter your symptom: ");
        String symptom = scanner.nextLine();

        String suggestion = symptomChecker.getSuggestion(symptom);
        System.out.println("AI Suggestion: " + suggestion);
    }

    static void bookAppointment() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter doctor name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter date (dd/mm/yyyy): ");
        String date = scanner.nextLine();

        System.out.print("Enter time (HH:mm): ");
        String time = scanner.nextLine();

        appointments.add(new Appointment(doctor, date, time, email));
        System.out.println("Appointment booked successfully with Dr. " + doctor);
    }

    static void viewAppointments() {
        System.out.println("Appointments:");
        for (Appointment appt : appointments) {
            System.out.println("Dr. " + appt.doctorName + " | Date: " + appt.date + " | Time: " + appt.time + " | For: " + appt.userEmail);
        }
    }
}
