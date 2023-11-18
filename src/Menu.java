import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Menu {

    public static List<JsonObject> loadJsontoJsonObject_students() {
        String importPathStudent = "import/student.json";
        Path path = Paths.get(importPathStudent);
        try {
            Gson gson = new Gson();
            String inputString = Files.readString(path);
            List<JsonObject> jsonObjectList = Arrays.asList(gson.fromJson(inputString, JsonObject[].class));
            jsonObjectList.forEach(System.out::println);
            return jsonObjectList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> loadJsontoStudent_students() {
        String importPathStudent = "import/student.json";
        Path path = Paths.get(importPathStudent);
        try {
            Gson gson = new Gson();
            String inputString = Files.readString(path);
            List<Student> importedStudentList = Arrays.asList(gson.fromJson(inputString, Student[].class));
            return importedStudentList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseStudentfromJson(List<JsonObject> JsonObjectList) {
        String lastName = JsonObjectList.get(0).getAsJsonObject("name").get("lastName").getAsString();
        String firstName = JsonObjectList.get(0).getAsJsonObject("name").get("firstName").getAsString();
        String uid = JsonObjectList.get(0).get("uid").getAsString();
        String studClass = JsonObjectList.get(0).get("StudClass").getAsString();


        System.out.println(lastName + " " + firstName);
        System.out.println(uid);
        System.out.println(studClass);

    }

    public static void exportStudentToJson() {

        Gson prettyGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
//                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())

        String output = prettyGson.toJson(Student.getAllStudentList());
        System.out.println(output);

        try {
            FileWriter fw = new FileWriter("export/student.json");
            fw.write(output);
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static LocalDate dateSearch(String inputDate) {
        return LocalDate.parse(inputDate);
    }

    public static ClassSerial classSerialSearch(String inputClassSerial) {
        int classSerialInt = Integer.parseInt(inputClassSerial);
        ClassSerial classSerial = ClassSerial.values()[classSerialInt - 1];
        return classSerial;
    }

    public static Subjects subjectSearch(String inputSubject) {
        Subjects subject = Arrays.stream(Subjects.values()).filter(sb -> sb.getSubjectName().toLowerCase().equals(inputSubject.toLowerCase())).findFirst().orElseThrow();
        return subject;
    }

    public static Teacher teacherSearch(String inputTeacher) {
        Teacher teacher = Teacher.getAllTeacherList().stream().filter(tch -> tch.getName().toString().equals(inputTeacher)).findFirst().orElseThrow();
        return teacher;
    }

    public static StudClass studClassSearch(String inputStudClass) {
        StudClass studClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(inputStudClass)).findFirst().orElseThrow();
        return studClass;
    }

    /**
     * Search according to the student's StudClass
     *
     * @return
     */
    public static Student studentSearch(String inputStudent) {
        Student student = Student.getAllStudentList().stream().filter(stud -> stud.getName().toString().equals(inputStudent)).findFirst().orElseThrow();
        return student;
    }

    public static Student studentSearchByUuidD(String inputUuid) {
        Student student = Student.getAllStudentList().stream().filter(stud -> stud.getUuid().equals(inputUuid)).findFirst().orElseThrow();
        return student;
    }

    public static String fillClassDiary() {
        System.out.println("1 - aktuális óra naplózása");
        LocalDate localDate = dateSearch(UserInterface.dateScan());
        ClassSerial classSerial = classSerialSearch(UserInterface.classSerialScan());
        Subjects subject = subjectSearch(UserInterface.subjectScan());
        Teacher teacher = teacherSearch(UserInterface.teacherScan());
        StudClass studClass = studClassSearch(UserInterface.studClassScan());
        new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent(UserInterface.numberOfAbsentScan());
        String result = "Sikeres naplózás!";
        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
        System.out.println(result);
        return result;
    }

    public static void modifyClassDiary() {
        System.out.println("Meglévő naplóadatok módosítása");
    }

    public static void saveGrade() {
        System.out.println("Jegy beírása");
        Student student = Menu.studentSearch(UserInterface.studentScan());
        Subjects subject = Menu.subjectSearch(UserInterface.subjectScan());
        String[] grades = UserInterface.gradeScan();
        student.addGrade(subject, grades);
        System.out.println("Jegy beírása sikeres");
    }


}
