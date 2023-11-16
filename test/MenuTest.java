import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.util.Scanner;


public class MenuTest {
    Scanner mockScanner = mock(Scanner.class);
    Teacher mockTeacher = mock(Teacher.class);
    ClassDiary mockClassDiary = mock(ClassDiary.class);
    Student mockStudent = mock(Student.class);
    UserInterface mockUserInterface = mock(UserInterface.class);
    StudClass mockStudClass = mock(StudClass.class);

    @BeforeEach
    public void setUpMockObjects() {
                this.mockTeacher = new Teacher(new Name("Tört", "Elek"), Subjects.HISTORY);
                this.mockStudClass = new StudClass(mockTeacher, "12A");
                this.mockStudent = new Student(new Name("Nemecsek", "Ernő"), mockStudClass);
    }

    @Test
    public void StudentSearchShouldReturnAStudent() {
        assertSame(mockTeacher, Menu.teacherSearch("Tört Elek"), "Not the same String!");
    }
//    @Test
//    public void TeacherSearchShouldReturnATeacher() {
//        assertSame(mockStudent, Menu.StudentSearch("Nemecsek Ernő"), "Not the same String!");
//    }



//    @Test
//    public void TeacherScannerShouldReturnSameString() {
//        String result = "Tört Elek";
//        when(mockScanner.next()).thenReturn(result);
//        when(mockScanner.nextLine()).thenReturn(result);
//        assertSame(result, UserInterface.TeacherScanner(), "Not the same String!");
//    }


//    @Test
//    void ShouldPrintFillDiaryMenu() {
//        when(mockScanner.nextInt())
//                .thenReturn(0)
//                .thenReturn(3)
//                .thenReturn(1);
//        Menu.printMainPage(0);
//
//        when((mockScanner.next()))
//                .thenReturn("2001-02-03")
//                .thenReturn("2")
//                .thenReturn("Történelem")
//                .thenReturn("A B")
//                .thenReturn("12A")
//                .thenReturn("Kis János, betegség");
//        Menu.FillClassDiary();
//    }


}
