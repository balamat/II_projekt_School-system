import java.time.LocalDate;
import java.util.Scanner;

public class Log {

    public static int permission = 0;
    public static LocalDate actualDate = LocalDate.now();

    public static int login() {
//        System.out.println("Add meg a teljes neved (Vezetéknév Keresztnév1 Keresztnév2...)!");
//        Scanner usernameScanner = new Scanner(System.in);
//        String username = usernameScanner.nextLine();
//        usernameScanner.close();
//        search for equal username, if there is one, then it will scan its password

        System.out.println("Add meg, hogy milyen felhasználó vagy?");
        System.out.println("0 - Admin");
        System.out.println("1 - Tanár");
        System.out.println("2 - Diák");

        Scanner permissionScanner = new Scanner(System.in);
        int permission = permissionScanner.nextInt();
        return permission;
    }

    public static void logout() {

    }


}
