import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Log {

    /*
     * permission codes
     * 0 - admin
     * 1 - teacher
     * 2 - student
     */
    public static LocalDate actualDate = LocalDate.now();
    public static int permission;
    public static boolean isWrongInput = false;
    public static User user;

    public static void login() {
        user = userSearch();
        setPermission(user);
    }

    public static void setPermission(User user) {
        permission = 0;
        if (user instanceof Teacher) {
            permission = 1;
        } else if (user instanceof Student) {
            permission = 2;
        }
    }

    public static User userSearch() {
        List<User> allUserList = new ArrayList<>();
        Student.getAllStudentList().forEach(student -> allUserList.add(student.clone()));
        Teacher.getAllTeacherList().forEach(teacher -> allUserList.add(teacher.clone()));

        //set the admin!
        Admin admin = new Admin(new Name("Máté", "Balázs"));
        allUserList.add(admin.clone());

        do {
            try {
                System.out.println("Add meg a felhasználóneved!");
                String inputUserName = UserInterface.generalLineScan();
                User loginUser = allUserList.stream().filter(user -> user.getName().toString().equals(inputUserName))
                        .findFirst()
                        .orElseThrow();
                return loginUser;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen nevű felhasználó az iskolában!");
            }
        } while (isWrongInput);
        return null;
    }

    private int passwordValidator() {
        return 0;
    }

    public static void logout() {
        System.out.println("kilépés...");
    }

}
