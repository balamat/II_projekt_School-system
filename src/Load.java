import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Load {

    public static void parseStudentfromJson(List<JsonObject> JsonObjectList) {
        String lastName = JsonObjectList.get(0).getAsJsonObject("name").get("lastName").getAsString();
        String firstName = JsonObjectList.get(0).getAsJsonObject("name").get("firstName").getAsString();
        String uid = JsonObjectList.get(0).get("uid").getAsString();
        String studClass = JsonObjectList.get(0).get("StudClass").getAsString();


        System.out.println(lastName + " " + firstName);
        System.out.println(uid);
        System.out.println(studClass);

    }

    public static List<Student> loadJsonToStudent() {
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

    public static List<ClassDiary> loadJsonToClassDiary() {
        String importPathStudent = "import/classDiary.json";
        Path path = Paths.get(importPathStudent);
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
                .setPrettyPrinting()
                .create();
//                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())

        String output = prettyGson.toJson(Student.getAllStudentList());

        try {
            FileWriter fw = new FileWriter("export/student.json");
            fw.write(output);
            fw.close();

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
            FileWriter fw = new FileWriter("export/classDiary.json");
            fw.write(output);
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
