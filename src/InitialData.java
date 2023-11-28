import java.time.LocalDate;
import java.util.ArrayList;

public class InitialData {


//        Teacher teacher01 = new Teacher(new Name("A", "B"), Subjects.HISTORY).addToList();
//        Teacher teacher02 = new Teacher(new Name("Tört", "Elek"), Subjects.MATHS).addToList();
//        Teacher teacher03 = new Teacher(new Name("Kós", "Károly"), Subjects.PHYSICS).addToList();
//        Teacher teacher04 = new Teacher(new Name("Jó", "Ferenc"), Subjects.ENGLISH, Subjects.GERMAN).addToList();
//        Teacher teacher05 = new Teacher(new Name("Nemoda", "Norbert"), Subjects.SPORT).addToList();
//        new Teacher(new Name("Jürgen", "Klopp"), Subjects.SPORT, Subjects.GERMAN).addToList();
//        new Teacher(new Name("Bolyai", "János"), Subjects.MATHS, Subjects.PHYSICS).addToList();
//        new Teacher(new Name("Neumann", "János"), Subjects.MATHS).addToList();
//        new Teacher(new Name("Karinthy", "Frigyes"), Subjects.HUNGARIAN).addToList();
//        new Teacher(new Name("Móricz", "Zsigmond"), Subjects.HUNGARIAN, Subjects.HISTORY).addToList();
//        new Teacher(new Name("Atkinson", "Rowan"), Subjects.ENGLISH).addToList();
//        new Teacher(new Name("Hill", "Benny"), Subjects.ENGLISH, Subjects.SPORT).addToList();
//        new Teacher(new Name("Öveges", "József"), Subjects.PHYSICS).addToList();
//        new Teacher(new Name("Thorma", "János"), Subjects.VISUAL_ARTS).addToList();
//        new Teacher(new Name("Bartók", "Béla"), Subjects.MUSIC).addToList();
//        new Teacher(new Name("Kodály", "Zoltán"), Subjects.MUSIC, Subjects.HISTORY).addToList();
//        new Teacher(new Name("Rossi", "Marco"), Subjects.SPORT, Subjects.ENGLISH).addToList();

//        StudClass A12 = new StudClass(teacher01, "12A").addToList();
//        StudClass B12 = new StudClass(teacher02, "12B").addToList();
//        StudClass C12 = new StudClass(teacher03, "12C").addToList();
//
        /*creating json structure by instantiating sample objects*/
//        Student student01 = new Student(new Name("Nagy", "János"), "12A").addToList();
//        Student student02 = new Student(new Name("Elekes", "Árpád"), "12A").addToList();
//        Student student03 = new Student(new Name("Kovács", "Kristóf"), "12A").addToList();
//        Student student04 = new Student(new Name("Zsolnay", "Péter"), "12A").addToList();
//        Student student05 = new Student(new Name("Király", "Sándor"), "12A").addToList();
//        Student student06 = new Student(new Name("Csoboth", "Kevin"), "12A").addToList();
//        Student student07 = new Student(new Name("Szoboszlai", "Dominik"), "12A").addToList();
//
//        Student student11 = new Student(new Name("Rooney", "Wayne"), "12B").addToList();
//        Student student12 = new Student(new Name("Ronaldo", "Cristiano"), "12B").addToList();
//        Student student13 = new Student(new Name("Giggs", "Ryan"), "12B").addToList();
//        Student student14 = new Student(new Name("Scholes", "Paul"), "12B").addToList();
//        Student student15 = new Student(new Name("Keane", "Roy"), "12B").addToList();
//        Student student16 = new Student(new Name("Solksjaer", "Ole Gunnar"), "12B").addToList();
//
//        ClassDiary classDiary01 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_1, Subjects.MATHS, teacher01, A12).addToList();
//        classDiary01.getAbsentStudents().put(student01.getUuid(), "puskázott, kiküldésre került");
//        classDiary01.getAbsentStudents().put(student02.getUuid(), "beteg");
//        classDiary01.getAbsentStudents().put(student07.getUuid(), "gittet rág");
//
//        ClassDiary classDiary02 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_2, Subjects.MATHS, teacher01, A12).addToList();
//        classDiary02.getAbsentStudents().put(student01.getUuid(), "Szavalóversenyen vesz részt.");
//        classDiary02.getAbsentStudents().put(student03.getUuid(), "Szavalóversenyen vesz részt.");
//        classDiary02.getAbsentStudents().put(student04.getUuid(), "Szavalóversenyen vesz részt.");
//
//        ClassDiary classDiary03 = new ClassDiary(LocalDate.now().minusDays(100), ClassSerial.CL_3, Subjects.MATHS, teacher01, A12).addToList();
//        classDiary03.getAbsentStudents().put(student01.getUuid(), "Matematika vesz részt.");
//        classDiary03.getAbsentStudents().put(student06.getUuid(), "Síel.");
//
//        student01.getSubjectAndGradeList().put(Subjects.MATHS, List.of(new Grade("doga1", 2), new Grade("felelet", 5)));
//        student01.getSubjectAndGradeList().put(Subjects.HISTORY, List.of(new Grade("doga2", 1), new Grade("felelet", 1)));
//        student01.getSubjectAndGradeList().put(Subjects.HUNGARIAN, List.of(new Grade("versmondás", 4), new Grade("felelet", 3)));
//        student01.getSubjectAndGradeList().put(Subjects.VISUAL_ARTS, List.of(new Grade("csendélet rajzolás", 2), new Grade("dolgozat - festők", 2)));
//        student01.getSubjectAndGradeList().put(Subjects.ENGLISH, List.of(new Grade("szódolgozat", 5), new Grade("felelet", 4), new Grade("szódolgozat javítása", 5), new Grade("témazáró 1.", 3)));
//
//        student07.getSubjectAndGradeList().put(Subjects.MATHS, List.of(new Grade("doga1", 2), new Grade("felelet", 5)));
//        student07.getSubjectAndGradeList().put(Subjects.HISTORY, List.of(new Grade("doga2", 2), new Grade("felelet", 5)));
//        student07.getSubjectAndGradeList().put(Subjects.HUNGARIAN, List.of(new Grade("versmondás", 1), new Grade("felelet", 3)));
//        student07.getSubjectAndGradeList().put(Subjects.VISUAL_ARTS, List.of(new Grade("csendélet rajzolás", 3), new Grade("dolgozat - festők", 5)));
//        student07.getSubjectAndGradeList().put(Subjects.ENGLISH, List.of(new Grade("szódolgozat", 1), new Grade("felelet", 5), new Grade("szódolgozat javítása", 5), new Grade("témazáró 1.", 3)));
//
//        A12.getClassTeachersBySubject().put(Subjects.ENGLISH, new ArrayList<Teacher>());
//        A12.getClassTeachersBySubject().get(Subjects.ENGLISH).add(teacher03);
//        A12.getClassTeachersBySubject().put(Subjects.HISTORY, new ArrayList<Teacher>());
//        A12.getClassTeachersBySubject().get(Subjects.HISTORY).add(teacher01);

//        StudClass.getAllStudClassList().get(0).getClassTeachersBySubject().put(Subjects.HUNGARIAN, new ArrayList<>());
//        StudClass.getAllStudClassList().get(0).getClassTeachersBySubject().get(Subjects.HUNGARIAN).add(Menu.teacherSearch());

//        Load.sortStudents();

}
