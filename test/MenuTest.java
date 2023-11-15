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

//    @BeforeEach
//    public void setUpMockObjects() {
//        this.mockTeacher = new Teacher(new Name("A", "B"), Subjects.HISTORY);
//    }

//    @Test
//    void TeacherSearchShouldReturnTeacher() {
//        when(mockScanner.next())
//                .thenReturn("A B");
//        assertSame(Menu.teacherSearch(), "Not equals with teacher01, who's name is 'A B'");
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
