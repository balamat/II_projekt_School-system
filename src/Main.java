import javax.security.auth.Subject;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //load
        //feltöltés adatokkal

        Student student01 = new Student(new Name("Kis", "János"));
        Teacher teacher01 = new Teacher(new Name("Kovács", "Béla"), Subject.MATHS);
        Admin admin01 = new Admin();


        //login
        Menu.chooseMainFunction(teacher01);
        Menu.chooseMainFunction(admin01);

        //check


        // szerepkörnek megfelelő mainPage

        //Funkció kiválasztása - ismétlődő, míg nem lépünk ki
        //diák - saját órarend, adatok és jegyek megnézése
        //tanár - naplózás, adatlekérés
        //admin - naplózás, adatlekérés
        // tanulók és tanárok megadása

        //adatlekérés - diák
        //adatlekérés - osztály


        //logout
        //lekérdezhető adatok - kimentés (export) json-ba


    }


}