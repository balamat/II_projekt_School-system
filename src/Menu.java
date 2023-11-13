import java.util.Scanner;

public class Menu {

    public static void chooseMainFunction(Object user) {
        System.out.println("Válassz a lehetőségek közül!");
        System.out.println("1 - Óra naplózása");
        System.out.println("2 - Osztályadatok elérése");
        System.out.println("3 - Tanulói adatok elérése");
        if (user instanceof Admin) {
            System.out.println("4 - Admin feladatok");
        }

        Scanner firstChoice = new Scanner(System.in);
        int menuChoice = firstChoice.nextInt();
        if (menuChoice == 1) {
            printClassDiary();
        } else if (menuChoice == 2) {
            printClass();
        } else if (menuChoice == 3) {
            printStudent();
        } else if (menuChoice == 4 && user instanceof Admin) {
            printAdmin();
        }
    }

    private static void printClassDiary() {
    }

    private static void printClass() {
    }

    private static void printStudent() {
    }

    private static void printAdmin() {
    }


}
