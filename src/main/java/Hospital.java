import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    public static HashMap<String, ArrayList> doctorClientRelation = new HashMap<>();
    public static List<Patient> listOfPatients = new ArrayList<>(); 
    public static List<String> typeOfDoctor = new ArrayList<>(3); 

    public static void addDoctor(String inputs, ArrayList list){ 
        doctorClientRelation.put(inputs, list); 
    }

    public static void addPatient(Patient patient){ 
        listOfPatients.add(patient); 
    }
}
