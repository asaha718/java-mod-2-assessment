import java.util.ArrayList;
import java.util.Scanner;

public class HospitalWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to Anug's Hospital World");
        System.out.println("what would you like the name of your Hospital to be? : ");

        try (Scanner scanner = new Scanner(System.in)) {
            String hospitalName = scanner.nextLine();
            
            if(hospitalName.isEmpty()) {
                System.out.println("Nothing was entered. Please try again");
                System.out.println("Enter the Name of the Hospital");
                
                hospitalName = scanner.nextLine();
            }

            System.out.println("###Welcome to " + hospitalName + " Hospital###");

            while (Hospital.doctorClientRelation.size() < 3) {
                addDocsToHospital(scanner);
            }

            while (Hospital.listOfPatients.size() < 5) {
                addPatientsToSystem(scanner);
            }

            System.out.println("~~~~~Summary of Todays Visits~~~~~~"); 

            for (String doc : Hospital.doctorClientRelation.keySet()) {
                System.out.println("Dr." + doc + " has " + Hospital.doctorClientRelation.get(doc).size() + " patients");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thank you for using Anug's Hospital System");
    }

    public static void addDocsToHospital(Scanner scanner) {

        System.out.println("Lets add a Doctor with a specialty to your Hospital");
        System.out.println("What is the Doctor's name : ");
        String docName = scanner.nextLine();

        if(docName.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            System.out.println("-Enter the Name of the Doctor-");
            docName = scanner.nextLine();
        }
             
        System.out.println("What is the Doctor's Specialty (ex. Dermatology, Pediatrics, Radiology...) : ");
        String specialty = scanner.nextLine();

        if (!Hospital.typeOfDoctor.contains(specialty)) {
            Hospital.typeOfDoctor.add(specialty);
        } else {
            System.out.println("===Sorry a Doctor for that specialty already exists===");
            System.out.println("What is the Doctor's Specialty (ex. Dermatology, Pediatrics, Radiology...) : ");
            specialty = scanner.nextLine();
            Hospital.typeOfDoctor.add(specialty);
        }

        Doctor newDoc = new Doctor(docName, specialty);

        Hospital.addDoctor(newDoc.name, new ArrayList<String>());
        System.out.println(newDoc.name + " has been added to the Hospital!");

    }

    public static void addPatientsToSystem(Scanner scanner) {
        System.out.println("***Lets add a Patient to your Hospital***");
        System.out.println("What is the Patient's name : ");
        String patientName = scanner.nextLine();

        if(patientName.isEmpty()) {
            System.out.println("Nothing was entered. Please try again");
            patientName = scanner.nextLine();
        }

        Patient enteringPatient = new Patient(patientName);

        Hospital.addPatient(enteringPatient);

        int i = 1;
        for (String type : Hospital.typeOfDoctor) {
            System.out.println(" Do they need to see a " + type + " use option " + i);
            i++;
        }

        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            String firstKey = (String) Hospital.doctorClientRelation.keySet().toArray()[0];

            // String docType = Hospital.typeOfDoctor.get(0);
            ArrayList patientList = Hospital.doctorClientRelation.get(firstKey);

            if (patientList == null || patientList.size() == 0) {
                Hospital.doctorClientRelation.put(firstKey, new ArrayList<String>());

                Hospital.doctorClientRelation.get(firstKey).add(enteringPatient.name);
            } else {
                Hospital.doctorClientRelation.get(firstKey).add(enteringPatient.name);
            }

        } else if ((userInput.equals("2"))) {

            String secondKey = (String) Hospital.doctorClientRelation.keySet().toArray()[1];

            ArrayList patientList = Hospital.doctorClientRelation.get(secondKey);

            if (patientList == null || patientList.size() == 0) {
                Hospital.doctorClientRelation.put(secondKey, new ArrayList<String>());

                Hospital.doctorClientRelation.get(secondKey).add(enteringPatient.name);
            } else {
                Hospital.doctorClientRelation.get(secondKey).add(enteringPatient.name);
            }

        } else if ((userInput.equals("3"))) {

            String thirdKey = (String) Hospital.doctorClientRelation.keySet().toArray()[1];

            ArrayList patientList = Hospital.doctorClientRelation.get(thirdKey);

            if (patientList == null || patientList.size() == 0) {
                Hospital.doctorClientRelation.put(thirdKey, new ArrayList<String>());
                Hospital.doctorClientRelation.get(thirdKey).add(enteringPatient.name);
            } else {
                Hospital.doctorClientRelation.get(thirdKey).add(enteringPatient.name);
            }

        } else {
            System.out.println("Incorrect key entry ");
            return;
        }

    }

}
