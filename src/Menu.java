import java.util.NoSuchElementException;
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
        System.out.println("---------------------------------------------");

//????????????????????????????????????????????????????????
//        Scanner menuChoiceScanner = new Scanner(System.in);
//        int menuChoice = menuChoiceScanner.nextInt();
//        menuChoiceScanner.close();
        int menuChoice = 2;

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

    //????????????????? alphabetic order of the students
    private static void printClass() {
        StudClass studClass = classSearch();
        System.out.println(studClass);
        studClass.getStudentList().forEach(System.out::println);
    }

    private static void printClassDiary() {

    }

    private static void printAdmin() {

    }

    public static StudClass classSearch() {
        StudClass.getAllStudClassList().forEach(System.out::println);
        System.out.println("Add meg a lekérendő diák osztályát!");
        Scanner classScanner = new Scanner(System.in);
        String searchedClass = classScanner.next();
        StudClass chosenClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(searchedClass)).findFirst().orElseThrow();
        return chosenClass;
    }


}
