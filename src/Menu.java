import java.time.LocalDate;
import java.util.*;

public class Menu {

    public static LocalDate dateSearch(String inputDate) {
        return LocalDate.parse(inputDate);
    }

    public static ClassSerial classSerialSearch(String inputClassSerial) {
        int classSerialInt = Integer.parseInt(inputClassSerial);
        ClassSerial classSerial = ClassSerial.values()[classSerialInt - 1];
        return classSerial;
    }

    public static Subjects subjectSearch(String inputSubject) {
        Subjects subject = Arrays.stream(Subjects.values()).filter(sb -> sb.getSubjectName().toLowerCase().equals(inputSubject.toLowerCase())).findFirst().orElseThrow();
        return subject;
    }

    public static Teacher teacherSearch(String inputTeacher) {
        Teacher teacher = Teacher.getAllTeacherList().stream().filter(tch -> tch.getName().toString().equals(inputTeacher)).findFirst().orElseThrow();
        return teacher;
    }

    public static StudClass studClassSearch(String inputStudClass) {
        StudClass studClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(inputStudClass)).findFirst().orElseThrow();
        return studClass;
    }

    /**
     * Search according to the student's StudClass
     *
     * @return
     */
    public static Student studentSearch(String inputStudent) {
        Student student = Student.getAllStudentList().stream().filter(stud -> stud.getName().toString().equals(inputStudent)).findFirst().orElseThrow();
        return student;
    }

    public static Student studentSearchByUuidD(String inputUuid) {
        Student student = Student.getAllStudentList().stream().filter(stud -> stud.getUuid().equals(inputUuid)).findFirst().orElseThrow();
        return student;
    }

    public static String fillClassDiary() {
        System.out.println("1 - aktuális óra naplózása");
        LocalDate localDate = dateSearch(UserInterface.dateScan());
        ClassSerial classSerial = classSerialSearch(UserInterface.classSerialScan());
        Subjects subject = subjectSearch(UserInterface.subjectScan());
        Teacher teacher = teacherSearch(UserInterface.teacherScan());
        StudClass studClass = studClassSearch(UserInterface.studClassScan());
        new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent(UserInterface.numberOfAbsentScan());
        String result = "Sikeres naplózás!";
        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
        System.out.println(result);
        return result;
    }

    public static void modifyClassDiary() {
        System.out.println("Meglévő naplóadatok módosítása");
    }

    public static void saveGrade() {
        System.out.println("Jegy beírása");
        Student student = Menu.studentSearch(UserInterface.studentScan());
        Subjects subject = Menu.subjectSearch(UserInterface.subjectScan());
        String[] grades = UserInterface.gradeScan();
        student.addGrade(subject, grades);
        System.out.println("Jegy beírása sikeres");
    }


}
