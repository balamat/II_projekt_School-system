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
import java.util.UUID;


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
        this.mockStudent = new Student(new Name("Nemecsek", "Ernő"), mockStudClass);
        this.mockDate = LocalDate.now();
        this.mockClassSerial = ClassSerial.CL_1;
        this.mockSubject = Subjects.HISTORY;

        String s = "8b7fc189-8200-4e30-87aa-06560b2830a7";
        when(mockStudent.getUuid()).thenReturn(UUID.fromString(s));
    }

    @Test
    public void teacherSearchShouldReturnTeacher() {
        assertEquals(mockTeacher.toString(), Menu.teacherSearch("Tört Elek").toString(), "Not the same String!");
    }

    @Test
    public void studentSearchShouldReturnStudent() {
        assertEquals(mockStudent.getName().toString(), Menu.studentSearch("Nemecsek Ernő").getName().toString(), "Not the same String!");
    }

    @Test
    public void studentSearchShouldThrowExceptionWhenNoMatch() {
        assertThrows(NoSuchElementException.class, () -> {
            Menu.studentSearch("Nemecsek");
        });
    }

    //    studentSearchByUuidD
    @Test
    public void studentSearchByUuidDShouldReturnStudent() {
        assertEquals("8b7fc189-8200-4e30-87aa-06560b2830a7", Menu.studentSearch("Nemecsek Ernő").getUuid().toString(), "Not the same String!");
    }
}
