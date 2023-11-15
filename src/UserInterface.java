import java.util.Scanner;

public class UserInterface {

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
        StudClass studClass = Menu.StudClassSearch(StudClassScanner());
        System.out.println(studClass);
        studClass.getStudentList().forEach(System.out::println);
    }

    private static void printClassDiary() {
        System.out.println("Naplóadatok");
        System.out.println("--------------------");
        printDiaryOptions();
    }

    public static void printDiaryOptions() {
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - aktuális óra naplózása");
        System.out.println("2 - meglévő naplóadatok módosítása");
        Scanner diaryOptionScanner = new Scanner(System.in);
        int diaryOptionChoice = diaryOptionScanner.nextInt();
        if (diaryOptionChoice == 1) {
            Menu.FillClassDiary();
        } else if (diaryOptionChoice == 2) {
            Menu.modifyClassDiary();
        }
    }

    public static String DateScanner() {
        System.out.println("Add meg az óra dátumát a megadott formátumban! [1999-11-11]");
        Scanner dateScanner = new Scanner(System.in);
        return dateScanner.next();
    }

    public static String ClassSerialScanner() {
        System.out.println("Add meg a rögzítendő óra sorszámát (1-9 között)!");
        Scanner classSerialScanner = new Scanner(System.in);
        return classSerialScanner.next();
    }

    public static String SubjectScanner() {
        System.out.println("Add meg a kiválasztandó óra nevét a megadott formátumban! [Történelem]");
        Scanner subjectScanner = new Scanner(System.in);
        return subjectScanner.next();
    }

    public static String TeacherScanner() {
        System.out.println("Add meg a tanár nevét!");
        Scanner teacherScanner = new Scanner(System.in);
        return teacherScanner.next();
    }

    public static String StudClassScanner() {
        System.out.println("Add meg az osztály jelét!");
        Scanner studClassScanner = new Scanner(System.in);
        return studClassScanner.next();
    }

    private static void printAdmin() {
    }
}
