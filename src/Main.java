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


        //??????
        //Load.sortStudents();
//        System.out.println(StudClass.getAllStudClassList().get(0).getStudentList().size());
//        System.out.println(StudClass.getAllStudClassList().get(1).getStudentList().size());
//        System.out.println(StudClass.getAllStudClassList().get(2).getStudentList().size());

        //mainPage                        //OK!!

        UserInterface.printMainPage();
        System.out.println();
        System.out.println(Student.getAllStudentList().size());
        System.out.println(StudClass.getAllStudClassList().size());
        System.out.println(StudClass.getAllStudClassList().get(0).getStudentList().size());
        System.out.println(StudClass.getAllStudClassList().get(1).getStudentList().size());
        System.out.println(StudClass.getAllStudClassList().get(2).getStudentList().size());
        System.out.println();
        System.out.println(Student.getAllStudentList().get(0).getSubjectAndGradeList().get(Subjects.GERMAN));
        System.out.println("----");
        System.out.println(StudClass.getAllStudClassList().get(0).getStudentList().get(0).getSubjectAndGradeList().get(Subjects.GERMAN));

//        UserInterface.printStudentGrades();
//        UserInterface.printStudClassGrades();


        //Functions
        //1- student info
        //personal info                     //OK!!
        //grade, average                    //OK!!
        //absence                           //OK!!
        //timetable
        //2 - class info                    //OK!!
        //class info
        //averages
        //timetable
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