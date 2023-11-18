import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //load - uploading data
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        Student.getAllStudentList().addAll(Load.loadJsonToStudent());
        ClassDiary.getAllClassDiary().addAll(Load.loadJsonToClassDiary());

        System.out.println(Student.getAllStudentList());
        Student student = Student.getAllStudentList().get(0);
        System.out.println(student.getSubjectAndGradeList().get(Subjects.MATHS).get(0).getGrade());
        System.out.println(student.getSubjectAndGradeList().get(Subjects.MATHS).get(0).getDescription());

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println(ClassDiary.getAllClassDiary());
        System.out.println("--------------------------------");

        LocalDate actualDate = LocalDate.now();

        Admin admin01 = new Admin();

        {
            Teacher teacher01 = new Teacher(new Name("A", "B"), Subjects.HISTORY);
            Teacher teacher02 = new Teacher(new Name("Tört", "Elek"), Subjects.MATHS);
            Teacher teacher03 = new Teacher(new Name("Kós", "Károly"), Subjects.PHYSICS);
            Teacher teacher04 = new Teacher(new Name("Jó", "Ferenc"), Subjects.ENGLISH, Subjects.GERMAN);
            Teacher teacher05 = new Teacher(new Name("Nemoda", "Norbert"), Subjects.SPORT);

            StudClass A12 = new StudClass(teacher01, "12A");
            StudClass B12 = new StudClass(teacher02, "12B");
            StudClass C12 = new StudClass(teacher03, "12C");

            Student student01 = new Student(new Name("Nagy", "János"), A12);
            Student student02 = new Student(new Name("Elekes", "Árpád"), A12);
            Student student03 = new Student(new Name("Kovács", "Kristóf"), A12);
            Student student04 = new Student(new Name("Zsolnay", "Péter"), A12);
            Student student05 = new Student(new Name("Király", "Sándor"), A12);
            Student student06 = new Student(new Name("Csoboth", "Kevin"), A12);
            Student student07 = new Student(new Name("Szoboszlai", "Dominik"), A12);

            Student student11 = new Student(new Name("Rooney", "Wayne"), B12);
            Student student12 = new Student(new Name("Ronaldo", "Cristiano"), B12);
            Student student13 = new Student(new Name("Giggs", "Ryan"), B12);
            Student student14 = new Student(new Name("Scholes", "Paul"), B12);
            Student student15 = new Student(new Name("Keane", "Roy"), B12);
            Student student16 = new Student(new Name("Solksjaer", "Ole Gunnar"), B12);

            ClassDiary classDiary01 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_1, Subjects.MATHS, teacher01, A12);
            classDiary01.getAbsentStudents().put(student01.getUuid(), "puskázott, kiküldésre került");
            classDiary01.getAbsentStudents().put(student02.getUuid(), "beteg");
            classDiary01.getAbsentStudents().put(student07.getUuid(), "gittet rág");

            ClassDiary classDiary02 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_2, Subjects.MATHS, teacher01, A12);
            classDiary02.getAbsentStudents().put(student01.getUuid(), "Szavalóversenyen vesz részt.");
            classDiary02.getAbsentStudents().put(student03.getUuid(), "Szavalóversenyen vesz részt.");
            classDiary02.getAbsentStudents().put(student04.getUuid(), "Szavalóversenyen vesz részt.");

            ClassDiary classDiary03 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_3, Subjects.MATHS, teacher01, A12);
            classDiary03.getAbsentStudents().put(student01.getUuid(), "Matematika vesz részt.");
            classDiary03.getAbsentStudents().put(student06.getUuid(), "Síel.");

            student01.getSubjectAndGradeList().put(Subjects.MATHS, List.of(new Grade("doga1", 2), new Grade("felelet", 5)));
            student01.getSubjectAndGradeList().put(Subjects.HISTORY, List.of(new Grade("doga2", 1), new Grade("felelet", 1)));
            student01.getSubjectAndGradeList().put(Subjects.HUNGARIAN, List.of(new Grade("versmondás", 4), new Grade("felelet", 3)));
            student01.getSubjectAndGradeList().put(Subjects.VISUAL_ARTS, List.of(new Grade("csendélet rajzolás", 2), new Grade("dolgozat - festők", 2)));
            student01.getSubjectAndGradeList().put(Subjects.ENGLISH, List.of(new Grade("szódolgozat", 5), new Grade("felelet", 4), new Grade("szódolgozat javítása", 5), new Grade("témazáró 1.", 3)));

            student07.getSubjectAndGradeList().put(Subjects.MATHS, List.of(new Grade("doga1", 2), new Grade("felelet", 5)));
            student07.getSubjectAndGradeList().put(Subjects.HISTORY, List.of(new Grade("doga2", 2), new Grade("felelet", 5)));
            student07.getSubjectAndGradeList().put(Subjects.HUNGARIAN, List.of(new Grade("versmondás", 1), new Grade("felelet", 3)));
            student07.getSubjectAndGradeList().put(Subjects.VISUAL_ARTS, List.of(new Grade("csendélet rajzolás", 3), new Grade("dolgozat - festők", 5)));
            student07.getSubjectAndGradeList().put(Subjects.ENGLISH, List.of(new Grade("szódolgozat", 1), new Grade("felelet", 5), new Grade("szódolgozat javítása", 5), new Grade("témazáró 1.", 3)));

            A12.getClassTeachersBySubject().put(Subjects.ENGLISH, new ArrayList<Teacher>());
            A12.getClassTeachersBySubject().get(Subjects.ENGLISH).add(teacher03);
            A12.getClassTeachersBySubject().put(Subjects.HISTORY, new ArrayList<Teacher>());
            A12.getClassTeachersBySubject().get(Subjects.HISTORY).add(teacher01);
        }

        //login
        //scanner - user
        //scanner -password

        //load

        //mainPage
//        UserInterface.printMainPage(0);


//        UserInterface.printMainPage(0);

        


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

        Load.exportStudentToJson();
        Load.exportClassDiaryToJson();

    }


}