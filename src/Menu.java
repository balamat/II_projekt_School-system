import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static LocalDate DateSearch(String inputDate) {
        return LocalDate.parse(inputDate);
    }

    public static ClassSerial ClassSerialSearch(String inputClassSerial) {
        int classSerialInt = Integer.parseInt(inputClassSerial);
        ClassSerial classSerial = ClassSerial.values()[classSerialInt - 1];
        return classSerial;
    }

    public static Subjects SubjectSearch(String inputSubject) {
        Subjects subject = Arrays.stream(Subjects.values()).filter(sb -> sb.getSubjectName().toLowerCase().equals(inputSubject.toLowerCase())).findFirst().orElseThrow();
        return subject;
    }

    public static Teacher TeacherSearch(String inputTeacher) {
        Teacher teacher = Teacher.getAllTeacherList().stream().filter(tch -> tch.getName().toString().equals(inputTeacher)).findFirst().orElseThrow();
        return teacher;
    }

    public static StudClass StudClassSearch(String inputStudClass) {
        StudClass studClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(inputStudClass)).findFirst().orElseThrow();
        return studClass;
    }

    /**
     * Search according to the student's StudClass
     *
     * @return
     */
    public static Student studentSearch(StudClass studClass) {
        System.out.println("Add meg a diák teljes nevét!");
        Scanner studentScanner = new Scanner(System.in);
        String studentNameString = studentScanner.next();
        Student searchedStudent = studClass.getStudentList().stream().filter(st -> st.getName().equals(studentNameString)).findFirst().orElseThrow();
        return searchedStudent;
    }

    public static int numberOfAbsentScanner() {
        System.out.println("Add meg a hiányzók számát!");
        Scanner numberOfAbsentScanner = new Scanner(System.in);
        int numberOfAbsent = numberOfAbsentScanner.nextInt();
        numberOfAbsentScanner.close();
        return numberOfAbsent;
    }

    public static String FillClassDiary() {
        System.out.println("1 - aktuális óra naplózása");
        LocalDate localDate = DateSearch(UserInterface.DateScanner());
        ClassSerial classSerial = ClassSerialSearch(UserInterface.ClassSerialScanner());
        Subjects subject = SubjectSearch(UserInterface.SubjectScanner());
        Teacher teacher = TeacherSearch(UserInterface.TeacherScanner());
        StudClass studClass = StudClassSearch(UserInterface.StudClassScanner());
//        int absentNumber = numberOfAbsentScanner();
        new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent();
        String result = "Sikeres naplózás!";
        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
        System.out.println(result);
        return result;
    }

    public static void modifyClassDiary() {
        System.out.println("2 - meglévő naplóadatok módosítása");
    }

}
