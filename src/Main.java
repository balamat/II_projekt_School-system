import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        //load - uploading data
        Teacher.getAllTeacherList().addAll(Load.loadJsonToTeacher());
        Student.getAllStudentList().addAll(Load.loadJsonToStudent());
        ClassDiary.getAllClassDiary().addAll(Load.loadJsonToClassDiary());
        StudClass.getAllStudClassList().addAll(Load.loadJsonToStudClass());

        //login
        //scanner - user
        //scanner -password


        //??????
        //Load.sortStudents();
        System.out.println(StudClass.getAllStudClassList().get(0).getStudentList().size());
        System.out.println(StudClass.getAllStudClassList().get(1).getStudentList().size());
        System.out.println(StudClass.getAllStudClassList().get(2).getStudentList().size());

        //mainPage                        //OK!!

        UserInterface.printStudentGrades();
        UserInterface.printStudClassGrades();



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

        Load.exportTeacherToJson();
        Load.exportStudentToJson();
        Load.exportClassDiaryToJson();
        Load.exportStudClassToJson();

    }


}