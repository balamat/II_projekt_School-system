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

        //login
        //scanner - user
        //scanner -password


        //mainPage                        //OK!!
//        UserInterface.printMainPage();

        UserInterface.printMainPage();
//        UserInterface.printStudentGrades();
//        UserInterface.printStudClassGrades();

        //Functions
        //1- student info                   //OK!!
        //personal info                     //OK!!
        //grade, average                    //OK!!
        //absence                           //OK!!

        //2 - class info                    //OK!!
        //class info                        //OK!!
        //averages                          //OK!!
        //absence                           //OK!!

        //3 - fill diary                    //OK!!
        //fill classDiary                   //OK!!
        //modify classDiary                 //OK!!
        //mark                              //OK!!
        
        //4 - admin tasks
        //add-modify-delete student
        //add-modify-delete class
        //add-modify-delete teacher

        //logout
        //save specific data - a certain class/student to CSV

        //auto export toJson                //OK!!
        Load.exportToJson();

    }
}