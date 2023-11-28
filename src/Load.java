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
        String importPath = "out/artifacts/project2_school_system_jar/files/schoolSystem.json";

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

    public static void loadArchiveFromJson() {
        String importPath = "out/artifacts/project2_school_system_jar/files/schoolSystem_archive.json";
        Path path = Paths.get(importPath);

        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            String inputString = Files.readString(path);
            List<JsonArray> importedList = Arrays.asList(gson.fromJson(inputString, JsonArray[].class));

            JsonArray jsonArrayStudent = importedList.get(0);
            JsonArray jsonArrayStudClass = importedList.get(1);

            List<Student> importListStudent = Arrays.asList(gson.fromJson(jsonArrayStudent, Student[].class));
            List<StudClass> importListStudClass = Arrays.asList(gson.fromJson(jsonArrayStudClass, StudClass[].class));

            Student.getArchivedStudentList().addAll(importListStudent);
            StudClass.getArchivedStudClassList().addAll(importListStudClass);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportToJson() {
        Gson prettyGson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        List<Object> totalList = new ArrayList<>();
        totalList.add(Student.getAllStudentList());
        totalList.add(Teacher.getAllTeacherList());
        totalList.add(StudClass.getAllStudClassList());
        totalList.add((ClassDiary.getAllClassDiary()));

        List<Object> archivedTotalList = new ArrayList<>();
        archivedTotalList.add(Student.getArchivedStudentList());
        archivedTotalList.add(StudClass.getArchivedStudClassList());

        String output = prettyGson.toJson(totalList);
        String archivedOutput = prettyGson.toJson(archivedTotalList);

        try {
            FileWriter fw = new FileWriter("out/artifacts/project2_school_system_jar/files/schoolSystem.json");
            fw.write(output);
            fw.close();
            FileWriter fw_backup = new FileWriter("out/artifacts/project2_school_system_jar/files/backup/schoolSystem_" + backupVersion() + ".json");
            fw_backup.write(output);
            fw_backup.close();
            FileWriter fw_archive = new FileWriter("out/artifacts/project2_school_system_jar/files/schoolSystem_archive.json");
            fw_archive.write(archivedOutput);
            fw_archive.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
