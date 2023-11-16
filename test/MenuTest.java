import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MenuTest {
    Scanner mockScanner = mock(Scanner.class);
    Teacher mockTeacher = mock(Teacher.class);
    ClassDiary mockClassDiary = mock(ClassDiary.class);
    Student mockStudent = mock(Student.class);
    UserInterface mockUserInterface = mock(UserInterface.class);
    StudClass mockStudClass = mock(StudClass.class);
    ClassSerial mockClassSerial = mock(ClassSerial.class);
    LocalDate mockDate = mock(LocalDate.class);
    Subjects mockSubject = mock(Subjects.class);

    @BeforeEach
    public void setUpMockObjects() {
        this.mockTeacher = new Teacher(new Name("Tört", "Elek"), mockSubject);
        this.mockStudClass = new StudClass(mockTeacher, "12A");
        this.mockStudent = new Student(new Name("Nemecsek", "Ernő"), mockStudClass);
        this.mockDate = LocalDate.now();
        this.mockClassSerial = ClassSerial.CL_1;
        this.mockSubject = Subjects.HISTORY;
    }

    @Test
    public void teacherSearchShouldReturnTeacher() {
        assertEquals(mockTeacher.toString(), Menu.teacherSearch("Tört Elek").toString(), "Not the same String!");
    }

    @Test
    public void studentSearchShouldReturnStudent() {
        assertEquals(mockStudent.toString(), Menu.studentSearch("Nemecsek Ernő").toString(), "Not the same String!");
    }

    @Test
    public void studentSearchShouldThrowExceptionWhenNoMatch() {
        assertThrows(NoSuchElementException.class, () -> {
            Menu.studentSearch("Nemecsek");
        });
    }

    @Test
    void teacherSearchShouldTakeTeacherInput() {
    }


    @Test
    void fillClassDiaryShouldValidateSuccesfullDiarySave() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try (MockedStatic<Menu> utilities = Mockito.mockStatic(Menu.class)) {
//            utilities.when(Menu::FillClassDiary).thenReturn("xyz");
            utilities.when(()->Menu.dateSearch("2022-02-22")).thenReturn(mockDate);
            utilities.when(()->Menu.classSerialSearch("x")).thenReturn(mockClassSerial);
            utilities.when(()->Menu.subjectSearch("x")).thenReturn(mockSubject);
            utilities.when(()->Menu.teacherSearch("x")).thenReturn(mockTeacher);
            utilities.when(()->Menu.studClassSearch("x")).thenReturn(mockStudClass);
            utilities.when(()->Menu.studentSearch("x")).thenReturn(mockStudent);
            assertEquals("Sikeres naplózás!", Menu.FillClassDiary(), "Nem egyezik!");
        }
    }

}
