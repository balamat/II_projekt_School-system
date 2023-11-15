import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class MenuTest {
    Scanner mockScanner = mock(Scanner.class);
    Teacher mockTeacher = mock(Teacher.class);

    @BeforeEach
    public void setUpMockObjects() {
        this.mockTeacher = new Teacher(new Name("A", "B"), Subjects.HISTORY);
    }


    public void addObjects() {
        Admin admin01 = new Admin();

        Teacher teacher01 = new Teacher(new Name("A", "B"), Subjects.HISTORY);
        Teacher teacher02 = new Teacher(new Name("Tört", "Elek"), Subjects.MATHS);
        Teacher teacher03 = new Teacher(new Name("Jóó", "Ferenc"), Subjects.ENGLISH, Subjects.GERMAN);
        Teacher teacher04 = new Teacher(new Name("Kóssa", "Zoltán"), Subjects.PHYSICS);
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

        A12.getClassTeachersBySubject().put(Subjects.ENGLISH, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.ENGLISH).add(teacher03);
        A12.getClassTeachersBySubject().put(Subjects.HISTORY, new ArrayList<Teacher>());
        A12.getClassTeachersBySubject().get(Subjects.HISTORY).add(teacher01);
    }

    @Test
    void TeacherSearchShouldReturnTeacher() {
        when(mockScanner.next())
                .thenReturn("A B");
        assertSame(mockTeacher, Menu.teacherSearch(), "Not equals with teacher01, who's name is 'A B'");
    }


//    void Given_Choices_Admin_ClassDiary_Should_FillDiary() {
//        when(Log.login()).thenReturn(0);
//        when(Menu.dateSearch()).thenReturn(LocalDate.now().minusMonths(1));
//        when(Menu.classSerialSearch()).thenReturn(ClassSerial.CL_1);
//        when(Menu.subjectSearch()).thenReturn(Subjects.ENGLISH);
//        when(Menu.teacherSearch()).thenReturn(teacher01);
//        when(Menu.studClassSearch()).thenReturn(A12);
//
//        Menu.printMainPage(Log.login());
//    }


}
