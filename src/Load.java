import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Load {

    public static String backupVersion() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uu-MM-dd_HH:mm:ss");
        String version = localDateTime.format(dtf);
        return version;
    }

    public static void loadFromJson() {
        String importPath = "files/schoolSystem.json";
        Path path = Paths.get(importPath);

        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            String inputString = Files.readString(path);
            List<JsonArray> importedList = Arrays.asList(gson.fromJson(inputString, JsonArray[].class));

            JsonArray jsonArrayStudent = importedList.get(0);
            JsonArray jsonArrayTeacher = importedList.get(1);
            JsonArray jsonArrayStudClass = importedList.get(2);
            JsonArray jsonArrayClassDiary = importedList.get(3);

            List<Student> importListStudent = Arrays.asList(gson.fromJson(jsonArrayStudent, Student[].class));
            List<Teacher> importListTeacher = Arrays.asList(gson.fromJson(jsonArrayTeacher, Teacher[].class));
            List<StudClass> importListStudClass = Arrays.asList(gson.fromJson(jsonArrayStudClass, StudClass[].class));
            List<ClassDiary> importListClassDiary = Arrays.asList(gson.fromJson(jsonArrayClassDiary, ClassDiary[].class));

            Student.getAllStudentList().addAll(importListStudent);
            Teacher.getAllTeacherList().addAll(importListTeacher);
            StudClass.getAllStudClassList().addAll(importListStudClass);
            ClassDiary.getAllClassDiary().addAll(importListClassDiary);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static void exportToJson() {

        Gson prettyGson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();


//        String jsonArrayStudent = prettyGson.toJson(Student.getAllStudentList());
//        String jsonArrayTeacher = prettyGson.toJson(Teacher.getAllTeacherList());
//        String jsonArrayStudClass = prettyGson.toJson(StudClass.getAllStudClassList());
//        String jsonArrayClassDiary = prettyGson.toJson(ClassDiary.getAllClassDiary());


        List<Object> totalList = new ArrayList<>();
        totalList.add(Student.getAllStudentList());
        totalList.add(Teacher.getAllTeacherList());
        totalList.add(StudClass.getAllStudClassList());
        totalList.add((ClassDiary.getAllClassDiary()));

        String output = prettyGson.toJson(totalList);


        try {
            FileWriter fw = new FileWriter("files/schoolSystem.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("files/backup/schoolSystem_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
