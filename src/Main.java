import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //load - uploading data
        LocalDate actualDate = LocalDate.now();

        //later - should be replaced with auto-generated data
        Student student01 = new Student(new Name("Kis", "János"));
        Student student02 = new Student(new Name("Kisebb", "László"));
        Student student03 = new Student(new Name("Közepes", "Kelemen"));
        Student student04 = new Student(new Name("Nagy", "Béla"));
        Student student05 = new Student(new Name("Nagyobb", "Imre"));
        Student student06 = new Student(new Name("Legnagyobb", "Ernő"));

        Teacher teacher01 = new Teacher(new Name("Történ", "Ferenc"), Subjects.HISTORY);
        Teacher teacher02 = new Teacher(new Name("Tört", "Elek"), Subjects.MATHS);
        Teacher teacher03 = new Teacher(new Name("Jóó", "Ferenc"), Subjects.ENGLISH, Subjects.GERMAN);
        Teacher teacher04 = new Teacher(new Name("Kóssa", "Zoltán"), Subjects.PHYSICS);
        Teacher teacher05 = new Teacher(new Name("Nemoda", "Norbert"), Subjects.SPORT);

        Admin admin01 = new Admin();

        StudClass A12 = new StudClass(teacher01, "12A");
        StudClass B12 = new StudClass(teacher02, "12B");

        A12.getStudentList().add(student01);
        A12.getStudentList().add(student02);
        A12.getStudentList().add(student03);
        B12.getStudentList().add(student04);
        B12.getStudentList().add(student05);
        B12.getStudentList().add(student06);

        //LATER!!!! not forbidden to add a teacher who do not teach that spicific subject
        A12.getClassTeachersBySubject().put(Subjects.ENGLISH, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.ENGLISH).add(teacher03);
        A12.getClassTeachersBySubject().put(Subjects.HISTORY, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.HISTORY).add(teacher01);


        //login
        //scanner - user
        //scanner -password
        //mainPage
        Menu.printMainPage(Log.login());

        //Functions
        //1- student info
        //basic
        //averages
        //timetable
        //absence
        //2 - class info
        //basic


        //averages
        //timetable
        //3 - fill diary
        //fill-edit classDiary
        //mark-absence
        //4 - admin tasks
        //add-modify-delete student
        //add-modify-delete class
        //add-modify-delete teacher

        //student - 1
        //teacher - 1,2,3
        //admin - 1,2,3,4


        //logout
        //auto export toJson


    }


}