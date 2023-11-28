import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        //load - uploading data
        Load.loadFromJson();
        Load.loadArchiveFromJson();

        //login
//        Log.login();

        //mainPage
        InitialData.initializeGrades();
        UserInterface.printMainPage();

        //Functions
        //1- student info
        //personal info
        //grade, average
        //absence

        //2 - studClass info
        //class info
        //averages
        //absence

        //3 - fill diary
        //fill classDiary
        //modify classDiary
        //mark
        //remove mark

        //4 - admin tasks
        //registrate new student
        //modify student data
        //archive student
        //registrate new studClass
        //modify studClass data
        //archive studClass

        //auto export toJson
//        Load.exportToJson();
    }
}