import java.time.LocalDate;
import java.util.ArrayList;

public class InitialData {

    public static void initializeGrades() {
        //generate random grades
        Student.getAllStudentList()
                .stream()
                .limit(75)
                .forEach(student -> student.generateRandomGrades(3, 5));
        Student.getAllStudentList()
                .stream()
                .skip(75)
                .limit(371)
                .forEach(student -> student.generateRandomGrades(1, 5));
        Student.getAllStudentList()
                .stream()
                .skip(446)
                .forEach(student -> student.generateRandomGrades(1, 3));
    }

}
