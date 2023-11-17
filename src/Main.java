import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //load - uploading data
        LocalDate actualDate = LocalDate.now();

        //later - should be replaced with auto-generated data

        Admin admin01 = new Admin();

        Teacher teacher01 = new Teacher(new Name("A", "B"), Subjects.HISTORY);
        Teacher teacher02 = new Teacher(new Name("Tört", "Elek"), Subjects.MATHS);
        Teacher teacher03 = new Teacher(new Name("Jó", "Ferenc"), Subjects.ENGLISH, Subjects.GERMAN);
        Teacher teacher04 = new Teacher(new Name("Kós", "Károly"), Subjects.PHYSICS);
        Teacher teacher05 = new Teacher(new Name("Nemoda", "Norbert"), Subjects.SPORT);

        StudClass A12 = new StudClass(teacher01, "12A");
        StudClass B12 = new StudClass(teacher02, "12B");

        Student student01 = new Student(new Name("Kis", "János"), A12);
        Student student02 = new Student(new Name("Kisebb", "László"), A12);
        Student student03 = new Student(new Name("Közepes", "Kelemen"), A12);
        Student student04 = new Student(new Name("Nagy", "Béla"), A12);
        Student student05 = new Student(new Name("Nagyobb", "Imre"), A12);
        Student student06 = new Student(new Name("Legnagyobb", "Ernő"), A12);
        Student student07 = new Student(new Name("Nemecsek", "Ernő"), A12);

        Student student11 = new Student(new Name("Rooney", "Wayne"), B12);
        Student student12 = new Student(new Name("Ronaldo", "Cristiano"), B12);
        Student student13 = new Student(new Name("Giggs", "Ryan"), B12);
        Student student14 = new Student(new Name("Scholes", "Paul"), B12);
        Student student15 = new Student(new Name("Keane", "Roy"), B12);
        Student student16 = new Student(new Name("Solksjaer", "Ole Gunnar"), B12);


        //LATER!!!! not forbidden to add a teacher who do not teach that spicific subject
        A12.getClassTeachersBySubject().put(Subjects.ENGLISH, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.ENGLISH).add(teacher03);
        A12.getClassTeachersBySubject().put(Subjects.HISTORY, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.HISTORY).add(teacher01);

        //login
        //scanner - user
        //scanner -password

        //load

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2023.11.17-re:
        //assginment, descr, subject, grade egyszerűsítése
        //!!Adatfeltöltés
        // Try-catch ágak
        // Adatlekérős pontok


        //mainPage


        Menu.fillClassDiary();
//        Menu.saveGrade();
        System.out.println(Menu.studentSearch("Nemecsek Ernő"));
        System.out.println(student07.getSubjectAndGradeList().entrySet());
//
//        String[] strings = UserInterface.AbsentScanner();
//        System.out.println(strings[0]);
//        System.out.println(strings[1]);


//        Menu.FillClassDiary();
//        System.out.println("----------------------------");
//        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
//        System.out.println(Menu.studentSearch("Nemecsek Ernő"));


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
        //fill classDiary-OK
        //modify classDiary
        //mark-OK
        //4 - admin tasks
        //add-modify-delete student
        //add-modify-delete class
        //add-modify-delete teacher

        //logout
        //auto export toJson


    }


}