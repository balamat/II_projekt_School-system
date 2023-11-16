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
        List<Student> searchedStudentList = new ArrayList<>();
        StudClass.getAllStudClassList().forEach(studClass -> studClass.getStudentList()
                .stream()
                .filter(student -> student.getName().toString().equals(inputStudent)).forEach(student -> searchedStudentList.add(student)));
        Student searchedStudent = searchedStudentList.stream().findFirst().orElseThrow();
        return searchedStudent;
    }

    public static String FillClassDiary() {
        System.out.println("1 - aktuális óra naplózása");
        LocalDate localDate = dateSearch(UserInterface.dateScanner());
        ClassSerial classSerial = classSerialSearch(UserInterface.classSerialScanner());
        Subjects subject = subjectSearch(UserInterface.subjectScanner());
        Teacher teacher = teacherSearch(UserInterface.teacherScanner());
        StudClass studClass = studClassSearch(UserInterface.studClassScanner());
//        int absentNumber = numberOfAbsentScanner();
        new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent(UserInterface.numberOfAbsentScanner());
        String result = "Sikeres naplózás!";
        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
        System.out.println(result);
        return result;
    }

    public static void modifyClassDiary() {
        System.out.println("Meglévő naplóadatok módosítása");
    }

    public static void addGrade() {
        System.out.println("Jegy beírása");

        //Scanner - Számonkérés neve, tárgy neve

        //Diák scanner
        //grade scanner
        //add grade
    }



}
