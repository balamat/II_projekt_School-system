import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    /**
     * permission codes
     * 0 - admin
     * 1 - teacher
     * 2 - student
     *
     * @param permission
     */
    public static void printMainPage(int permission) {
        System.out.println("Válassz a lehetőségek közül!");
        System.out.println("1 - Tanulói adatok elérése");
        if (permission == 0 || permission == 1) {
            System.out.println("2 - Osztályadatok elérése");
            System.out.println("3 - Óra naplózása");
        }
        if (permission == 0) {
            System.out.println("4 - Admin feladatok");
        }

        Scanner menuChoiceScanner = new Scanner(System.in);
        int menuChoice = menuChoiceScanner.nextInt();
        if (menuChoice == 1) {
            printStudent();
        }
        if (menuChoice == 2 && (permission == 0 || permission == 1)) {
            printClass();
        }
        if (menuChoice == 3 && (permission == 0 || permission == 1)) {
            printClassDiary();
        }
        if (menuChoice == 4 && permission == 0) {
            printAdmin();
        }
    }

    private static void printStudent() {
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //alphabetic order of the students - later to modify
    private static void printClass() {
        System.out.println("Osztályadatok");
        System.out.println("--------------------");
        StudClass.getAllStudClassList().forEach(System.out::println);
        StudClass studClass = studClassSearch();
        System.out.println(studClass);
        studClass.getStudentList().forEach(System.out::println);
    }

    private static void printClassDiary() {
        System.out.println("Naplóadatok");
        System.out.println("--------------------");
        printDiaryOptions();
    }

    private static void printAdmin() {
    }

    public static void printDiaryOptions() {
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - aktuális óra naplózása");
        System.out.println("2 - meglévő naplóadatok módosítása");
        Scanner diaryOptionScanner = new Scanner(System.in);
        int diaryOptionChoice = diaryOptionScanner.nextInt();
        if (diaryOptionChoice == 1) {
            fillClassDiary();
        } else if (diaryOptionChoice == 2) {
            modifyClassDiary();
        }
    }

    public static StudClass studClassSearch() {
        System.out.println("Add meg az osztály jelét!");
        Scanner classScanner = new Scanner(System.in);
        String searchedClass = classScanner.next();
        StudClass chosenClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(searchedClass)).findFirst().orElseThrow();
        return chosenClass;
    }

    public static LocalDate dateSearch() {
        System.out.println("Add meg az óra dátumát a megadott formátumban! [1999-11-11]");
        Scanner dateScanner = new Scanner(System.in);
        String dateString = dateScanner.next();
        return LocalDate.parse(dateString);
    }

    public static ClassSerial classSerialSearch() {
        System.out.println("Add meg a rögzítendő óra sorszámát (1-9 között)!");
        Scanner classSerialScanner = new Scanner(System.in);
        int classSerialInt = classSerialScanner.nextInt();
        ClassSerial classSerial = ClassSerial.values()[classSerialInt - 1];
        return classSerial;
    }

    public static Subjects subjectSearch() {
        System.out.println("Add meg a kiválasztandó óra nevét a megadott formátumban! [Történelem]");
        Scanner subjectScanner = new Scanner(System.in);
        String subjectNameString = subjectScanner.nextLine();
        Subjects searchedSubject = Arrays.stream(Subjects.values()).filter(sb -> sb.getSubjectName().toLowerCase().equals(subjectNameString.toLowerCase())).findFirst().orElseThrow();
        return searchedSubject;
    }

    public static Teacher teacherSearch() {
        System.out.println("Add meg a tanár nevét!");
        Scanner teacherScanner = new Scanner(System.in);
        String teacherNameString = teacherScanner.nextLine();
        Teacher searchedTeacher = Teacher.getAllTeacherList().stream().filter(tch -> tch.getName().toString().equals(teacherNameString)).findFirst().orElseThrow();
        return searchedTeacher;
    }

    /**
     * Search according to the student's StudClass
     *
     * @return
     */
    public static Student studentSearch(StudClass studClass) {
        System.out.println("Add meg a diák teljes nevét!");
        Scanner studentScanner = new Scanner(System.in);
        String studentNameString = studentScanner.nextLine();
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

    public static String fillClassDiary() {
        System.out.println("1 - aktuális óra naplózása");
        LocalDate localDate = dateSearch();
        ClassSerial classSerial = classSerialSearch();
        Subjects subject = subjectSearch();
        Teacher teacher = teacherSearch();
        StudClass studClass = studClassSearch();
        int absentNumber = numberOfAbsentScanner();
        new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent(numberOfAbsentScanner());
        String result = "Sikeres naplózás!";
        System.out.println(ClassDiary.getAllClassDiary().get(ClassDiary.getAllClassDiary().size() - 1));
        System.out.println(result);
        return result;
    }

    public static void modifyClassDiary() {
        System.out.println("2 - meglévő naplóadatok módosítása");
    }

}
