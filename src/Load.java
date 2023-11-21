import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Load {

    public static String backupVersion() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uu-MM-dd_HH:mm:ss");
        String version = localDateTime.format(dtf);
        return version;
    }

    /**
     * Sort the students by adding them to the correspondent StudClass from the list of all students
     */
    public static void sortStudents() {
        Student.getAllStudentList()
                .stream()
                .forEach(student -> {
                    StudClass.getAllStudClassList()
                            .forEach(studClass -> {
                                if (studClass.getNameOfClass().equals(student.getStudClassString())) {
                                    studClass.getStudentList().add(student);
                                }
                            });
                });
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

    public static List<Teacher> loadJsonToTeacher() {
        String importPath = "files/teacher.json";
        Path path = Paths.get(importPath);
        try {
            Gson gson = new Gson();
            String inputString = Files.readString(path);
            List<Teacher> importedList = Arrays.asList(gson.fromJson(inputString, Teacher[].class));
            return importedList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> loadJsonToStudent() {
        String importPath = "files/student.json";
        Path path = Paths.get(importPath);
        try {

//            Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            String inputString = Files.readString(path);
            List<Student> importedList = Arrays.asList(gson.fromJson(inputString, Student[].class));
            return importedList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<StudClass> loadJsonToStudClass() {
        String importPath = "files/studClass.json";
        Path path = Paths.get(importPath);
        try {
//            Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            String inputString = Files.readString(path);
            List<StudClass> importedList = Arrays.asList(gson.fromJson(inputString, StudClass[].class));
            return importedList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ClassDiary> loadJsonToClassDiary() {
        String importPath = "files/classDiary.json";
        Path path = Paths.get(importPath);
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();


            String inputString = Files.readString(path);
            List<ClassDiary> importedClassDiaryList = Arrays.asList(gson.fromJson(inputString, ClassDiary[].class));
            return importedClassDiaryList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportStudentToJson() {

        Gson prettyGson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        String output = prettyGson.toJson(Student.getAllStudentList());

        try {
            FileWriter fw = new FileWriter("files/student.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("files/backup/student_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportTeacherToJson() {

        Gson prettyGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String output = prettyGson.toJson(Teacher.getAllTeacherList());

        try {
            FileWriter fw = new FileWriter("files/teacher.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("files/backup/teacher_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportStudClassToJson() {

        Gson prettyGson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        String output = prettyGson.toJson(StudClass.getAllStudClassList());

        try {
            FileWriter fw = new FileWriter("files/studClass.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("files/backup/studClass_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void exportClassDiaryToJson() {

        Gson prettyGson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        String output = prettyGson.toJson(ClassDiary.getAllClassDiary());

        try {
            FileWriter fw = new FileWriter("files/classDiary.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("files/backup/classDiary_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
