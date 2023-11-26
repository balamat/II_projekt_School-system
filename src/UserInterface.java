import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.jar.JarOutputStream;

public class UserInterface {

    /**
     * permission codes
     * 0 - admin
     * 1 - teacher
     * 2 - student
     */
    public static void printMainPage() {
        int permission = Log.permission;
        System.out.println("Válassz a lehetőségek közül!");
        System.out.println("1 - Tanulói adatok elérése");
        if (Log.permission == 0 || permission == 1) {
            System.out.println("2 - Osztályadatok elérése");
            System.out.println("3 - Óra naplózása");
        }
        if (permission == 0) {
            System.out.println("4 - Admin feladatok");
        }

        Scanner menuChoiceScanner = new Scanner(System.in);
        int menuChoice = menuChoiceScanner.nextInt();
        if (menuChoice == 1) {
            printStudentInfo();
        }
        if (menuChoice == 2 && (permission == 0 || permission == 1)) {
            printStudClassInfo();
        }
        if (menuChoice == 3 && (permission == 0 || permission == 1)) {
            printClassDiary();
        }
        if (menuChoice == 4 && permission == 0) {
            printAdmin();
        }
    }

    public static void printStudentInfo() {
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - Diák adatainak lekérdezése");
        System.out.println("2 - Diák jegyeinek lekérdezése");
        System.out.println("3 - Diák hiányzásainak lekérdezése");
        int choice = Integer.parseInt(generalScan());
        switch (choice) {
            case 1:
                printStudentPersonalData();
                break;
            case 2:
                printStudentGrades();
                break;
            case 3:
                printStudentAbsence();
                break;
        }
    }

    public static void printStudentPersonalData() {
        String labelOfAction = "személyes adatok";
        System.out.println(labelOfAction.toUpperCase());

        System.out.println(Menu.studentSearch());
    }

    public static void printStudentGrades() {
        String labelOfAction = "jegyek lekérdezése";
        System.out.println(labelOfAction.toUpperCase());
        Student student = Menu.studentSearch();

        student.getSubjectAndGradeList().forEach((a, b) -> {
            System.out.println(a.getSubjectName() + ": \t" + b + " - átlag: " + Calculator.calculateStudentAvgBySubject(student, a));
        });

        double totalAvg = Calculator.calculateStudentAvg(student);
        System.out.println("---------------------------------------------------------");
        System.out.println("Tanulmányi átlag: " + totalAvg + System.lineSeparator());
    }

    public static void printStudentAbsence() {
        String labelOfAction = "hiányzások lekérdezése";
        System.out.println(labelOfAction.toUpperCase());
        Map<ClassDiary, String> classDiaryMap = ClassDiary.generateAbsenceMapByStudent(Menu.studentSearch());
        classDiaryMap.keySet().stream().sorted((a, b) -> a.getDate().compareTo(b.getDate())).forEach(classDiary -> System.out.println(classDiary.getDate().toString() + " - " + classDiary.getClassSerial() + ": " + classDiaryMap.get(classDiary)));
    }

    public static void printStudClassInfo() {
        System.out.println("Osztályadatok");
        System.out.println("--------------------");
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - Osztály adatainak lekérdezése");
        System.out.println("2 - Osztály jegyeinek lekérdezése");
        System.out.println("3 - Osztály hiányzásainak lekérdezése");
        int choice = Integer.parseInt(generalScan());
        switch (choice) {
            case 1:
                printStudClassData();
                break;
            case 2:
                printStudClassGrades();
                break;
            case 3:
                printStudClassAbsence();
                break;
        }
    }

    public static void printStudClassData() {
        String labelOfAction = "osztályadatok";
        System.out.println(labelOfAction.toUpperCase());

        System.out.println(Menu.studClassSearch());
    }

    public static void printStudClassGrades() {
        String labelOfAction = "osztály diákjainak átlagai";
        System.out.println(labelOfAction.toUpperCase());
        StudClass studClass = Menu.studClassSearch();

        DecimalFormat df = new DecimalFormat("0.00");
        int indent = 30;
        int tab = 4;
        int tabFirstRow = tab + 1;

        StringBuilder sbFirstRow = new StringBuilder();
        StringBuilder sbSubjDataPerStudent = new StringBuilder();
        StringBuilder sbLastRow = new StringBuilder();

        sbFirstRow.append(" ".repeat(indent));
        for (Subjects subject : Subjects.values()
        ) {
            sbFirstRow.append(subject.getSubjectName().substring(0, 3)).append(" ".repeat(tabFirstRow));
        }
        sbFirstRow.append("Átl");

        Student.getAllStudentList().stream()
                .filter(student -> student.getStudClassString().equals(studClass.getNameOfClass()))
                .forEach(student -> {
                    sbSubjDataPerStudent.append(student.getName()).append(" ".repeat(indent - student.getName().toString().length()));

                    Arrays.stream(Subjects.values()).forEach(subj ->
                            {
                                sbSubjDataPerStudent.append(df.format(Calculator.calculateStudentAvgBySubject(student, subj)))
                                        .append(" ".repeat(tab));
                            }
                    );
                    sbSubjDataPerStudent.append(df.format(Calculator.calculateStudentAvg(student)));
                    sbSubjDataPerStudent.append(System.lineSeparator());
                });

        sbLastRow.append(" ".repeat(indent));
        for (Subjects subject : Subjects.values()
        ) {
            sbLastRow.append(df.format(Calculator.calculateSubjectAvg(subject, studClass))).append(" ".repeat(tab));
        }
        sbLastRow.append(df.format(Calculator.calculateStudClassAvg(studClass)));

        System.out.println(sbFirstRow.toString());
        System.out.println(sbSubjDataPerStudent.toString());
        System.out.println(sbLastRow);
    }

    public static void printStudClassAbsence() {
        int indent = 30;
        int tab = 4;
        int tabFirstRow = tab + 1;
        StringBuilder sb = new StringBuilder();

        StudClass studClass = Menu.studClassSearch();
        Student.getAllStudentList().stream()
                .filter(student -> student.getStudClassString().equals(studClass.getNameOfClass()))
                .forEach(student -> {
                    sb.append(student.getName()).append(" ".repeat(indent - student.getName().toString().length()));
                    sb.append(" ".repeat(tab));
                    Set<ClassDiary> classDiaries = ClassDiary.generateAbsenceMapByStudent(student).keySet();
                    sb.append("Hiányzások: " + classDiaries.size()).append(" ".repeat(tab));
                    classDiaries.stream().forEach(i -> sb.append(i.getDate()).append(" - ").append(i.getClassSerial().getSerial() + ".óra").append(" ".repeat(tab)));
                    sb.append(System.lineSeparator());
                });
        System.out.println(sb);
    }

    public static void printClassDiary() {
        System.out.println("Naplóadatok");
        System.out.println("--------------------");
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - aktuális óra naplózása");
        System.out.println("2 - meglévő naplóadatok módosítása");
        System.out.println("3 - jegy beírása");
        Scanner diaryOptionScanner = new Scanner(System.in);
        int diaryOptionChoice = diaryOptionScanner.nextInt();
        if (diaryOptionChoice == 1) {
            Menu.fillClassDiary();
        } else if (diaryOptionChoice == 2) {
            Menu.modifyClassDiary();
        } else if (diaryOptionChoice == 3) {
            Menu.saveGrade();
        }
    }

    public static void printAdmin() {
        System.out.println("Admin műveletek");
        System.out.println("--------------------");
        System.out.println("Válassz a lehetőségek közül:");
        System.out.println("1 - új diák regisztrálása");
        System.out.println("2 - diák adatainak módosítása");
        System.out.println("3 - diák archiválása");
        System.out.println("4 - új osztály regisztrálása");
        System.out.println("5 - osztály adatainak módosítása");
        System.out.println("6 - osztály archiválása");
        Scanner diaryOptionScanner = new Scanner(System.in);
        int optionChoice = diaryOptionScanner.nextInt();
        switch (optionChoice) {
            case 1:
                UserInterface.adminAddNewStudent();
                break;
            case 2:
                UserInterface.adminModifyStudent();
                break;
            case 3:
                UserInterface.adminArchiveStudent();
                break;
            case 4:
                UserInterface.adminAddNewStudClass();
                break;
            case 5:
                UserInterface.adminModifyStudClass();
                break;
            case 6:
                UserInterface.adminArchiveStudClass();
                break;
        }
    }

    public static void adminAddNewStudent() {
        String labelOfAction = "új diák regisztrálása";
        System.out.println(labelOfAction.toUpperCase());

        System.out.println("Add meg a diák vezetéknevét!");
        String lastName = Menu.newNameValidator();
        System.out.println("Add meg a diák keresztnevét!");
        String firstName = Menu.newNameValidator();
        System.out.println("Add meg a diák születési dátumát!");
        LocalDate birthday = Menu.dateSearch();
        StudClass studClass = Menu.studClassSearch();

        new Student(new Name(lastName, firstName), studClass.getNameOfClass(), birthday).addToList();
        printSuccesfullyTerminated(labelOfAction);
    }

    public static void adminModifyStudent() {
        String labelOfAction = "diák adatainak módosítása";
        System.out.println(labelOfAction.toUpperCase());

        Student student = Menu.studentSearch();
        System.out.println(student);
        System.out.println("A diák osztálya módosítható. Akarod módosítani? Ha igen, nyomj egy \"I\"-t és entert!");
        String s = generalScan();
        if (s.toLowerCase().equals("i")) {
            System.out.println("Add meg, hogy melyik osztályba kerüljön át!");
            StudClass newStudClass = Menu.studClassSearch();
            student.setStudClassString(newStudClass.getNameOfClass());
            printSuccesfullyTerminated(labelOfAction);
            System.out.println(student);
        }
    }

    public static void adminArchiveStudent() {
        String labelOfAction = "diák archiválása";
        System.out.println(labelOfAction.toUpperCase());

        Student student = Menu.studentSearch();
        student.archive();
        printSuccesfullyTerminated(labelOfAction);
    }

    public static void adminAddNewStudClass() {
        String labelOfAction = "új osztály regisztrálása";
        System.out.println(labelOfAction.toUpperCase());

        System.out.println("Add meg az új osztály jelét!");
        String nameOfClass = Menu.newStudClassNameValidator();
        System.out.println("Add meg az osztályfőnök nevét");
        Teacher headTeacher = Menu.teacherSearch();
        new StudClass(headTeacher, nameOfClass).addToList();
        printSuccesfullyTerminated(labelOfAction);
    }

    public static void adminModifyStudClass() {
        String labelOfAction = "új osztály regisztrálása";
        System.out.println(labelOfAction.toUpperCase());

        System.out.println("1 - osztályfőnök módosítása");
        System.out.println("2 - oktató tanárok módosítása");

        Scanner optionScanner = new Scanner(System.in);
        int optionChoice = optionScanner.nextInt();
        switch (optionChoice) {
            case 1:
                UserInterface.adminModifyStudClassHeadTeacher();
                break;
            case 2:
                UserInterface.adminModifyStudClassTeacher();
                break;
        }
    }

    public static void adminModifyStudClassHeadTeacher() {
        String labelOfAction = "osztályfőnök módosítása";
        System.out.println(labelOfAction.toUpperCase());

        StudClass studClass = Menu.studClassSearch();
        System.out.println("Az eddigi osztályfőnök: " + studClass.getHeadTeacher().getName());
        System.out.println("Az új osztályfőnök:");
        Teacher newHeadTeacher = Menu.teacherSearch();
        studClass.setHeadTeacher(newHeadTeacher);
        printSuccesfullyTerminated(labelOfAction);
    }

    public static void adminModifyStudClassTeacher() {
        String labelOfAction = "oktató tanárok módosítása";
        System.out.println(labelOfAction.toUpperCase());

        StudClass studClass = Menu.studClassSearch();
        System.out.println(studClass.getClassTeachersBySubject().entrySet());
        System.out.println("Add meg a módosítandó tantárgyat!");
        Subjects subject = Menu.subjectSearch();
        System.out.println("Add meg a hozzáadandó/eltávolítandó tanár nevét!");
        Teacher modifiedTeacher = Menu.teacherSearch();

        if (studClass.getClassTeachersBySubject().containsKey(subject)) {
            List<Teacher> teacherList = studClass.getClassTeachersBySubject().get(subject);
            if (teacherList.stream().filter(teach -> teach.getUuid().equals(modifiedTeacher.getUuid())).count() > 0) {
                teacherList.removeIf(teacher -> teacher.getUuid().equals(modifiedTeacher.getUuid()));
            } else {
                teacherList.add(modifiedTeacher);
            }
        } else {
            studClass.getClassTeachersBySubject().put(subject, new ArrayList<>());
            studClass.getClassTeachersBySubject().get(subject).add(modifiedTeacher);
        }
        printSuccesfullyTerminated(labelOfAction);
    }

    public static void adminArchiveStudClass() {
        String labelOfAction = "osztály archiválása";
        System.out.println(labelOfAction.toUpperCase());

        StudClass studClass = Menu.studClassSearch();
        long count = Student.getAllStudentList().stream()
                .filter(student -> student.getStudClassString().equals(studClass.getNameOfClass()))
                .count();
        if (count > 0) {
            System.out.println("Az archiválandó osztályhoz " + count + " diák tartozik!");
            System.out.println("Melyik osztályba kerüljenek át a diákok?");
            StudClass destinationStudClass = Menu.studClassSearch();
            Student.getAllStudentList().stream()
                    .filter(student -> student.getStudClassString().equals(studClass.getNameOfClass()))
                    .forEach(student -> student.setStudClassString(destinationStudClass.getNameOfClass()));
        }
        studClass.archive();
        printSuccesfullyTerminated(labelOfAction);
    }


    public static void printSuccesfullyTerminated(String label) {
        System.out.println(label + " - a művelet sikeresen megtörtént!");
    }

    /*----------------------------SCANNERS----------------------------*/

    public static String generalScan() {
        Scanner generalScanner = new Scanner(System.in);
        return generalScanner.next();
    }

    public static String generalLineScan() {
        Scanner generalScanner = new Scanner(System.in);
        return generalScanner.nextLine();
    }

    public static String dateScan() {
        System.out.println("Add meg az óra dátumát a megadott formátumban! [1999-11-11]");
        Scanner dateScanner = new Scanner(System.in);
        return dateScanner.next();
    }

    public static String classSerialScan() {
        System.out.println("Add meg a rögzítendő óra sorszámát (1-9 között)!");
        Scanner classSerialScanner = new Scanner(System.in);
        return classSerialScanner.next();
    }

    public static String subjectScan() {
        System.out.println("Add meg a kiválasztandó óra nevét a megadott formátumban!");

        System.out.printf("Az alábbiak közül választhatsz: ");
        StringBuilder sbSubject = new StringBuilder();
        for (Subjects subject : Subjects.values()
        ) {
            sbSubject.append(subject.getSubjectName()).append(", ");
        }
        sbSubject.deleteCharAt(sbSubject.length() - 1).deleteCharAt(sbSubject.length() - 1);
        System.out.println(sbSubject.toString());

        Scanner subjectScanner = new Scanner(System.in);
        return subjectScanner.next();
    }

    public static String studClassScan() {
        System.out.println("Add meg az osztály jelét a megadott formában [12A]!");

        System.out.printf("Az alábbiak közül választhatsz: ");
        StringBuilder sbStudClass = new StringBuilder();
        StudClass.getAllStudClassList().stream().map(studClass -> studClass.getNameOfClass().toString()).sorted().forEach(studClass -> sbStudClass.append(studClass).append(", "));
        sbStudClass.deleteCharAt(sbStudClass.length() - 1).deleteCharAt(sbStudClass.length() - 1);
        System.out.println(sbStudClass.toString());

        Scanner studClassScanner = new Scanner(System.in);
        return studClassScanner.next();
    }

    public static String teacherScan() {
        System.out.println("Add meg a tanár teljes nevét!");

        System.out.printf("Az alábbiak oktatók közül választhatsz: ");
        StringBuilder sbTeacher = new StringBuilder();
        Teacher.getAllTeacherList().stream().map(teacher -> teacher.getName().toString()).sorted().forEach(teacher -> sbTeacher.append(teacher).append(", "));
        sbTeacher.deleteCharAt(sbTeacher.length() - 1).deleteCharAt(sbTeacher.length() - 1);
        System.out.println(sbTeacher.toString());

        Scanner teacherScanner = new Scanner(System.in);
        return teacherScanner.nextLine();
    }

    public static String studentScan() {
        System.out.println("Add meg a diák teljes nevét!");
        Scanner studentScanner = new Scanner(System.in);
        return studentScanner.nextLine();
    }

    public static String numberOfAbsentScan() {
        System.out.println("Add meg a hiányzók számát!");
        Scanner numberOfAbsentScanner = new Scanner(System.in);
        return numberOfAbsentScanner.next();
    }

    public static String absenceCauseScan() {
        Scanner absenseScanner = new Scanner(System.in);
        System.out.println("Add meg a hiányzás okát!");
        String absenceCause = absenseScanner.nextLine().trim();
        return absenceCause;
    }

    public static String gradeScan() {
        Scanner gradeScanner = new Scanner(System.in);
        System.out.println("Add meg az osztályzatot (1-5)!");
        return gradeScanner.next();
    }

    public static String gradeDescriptionScan() {
        Scanner gradeDescriptionScanner = new Scanner(System.in);
        System.out.println("Add meg az osztályzás címét (pl. szódolgozat)!");
        return gradeDescriptionScanner.nextLine().trim();
    }

}
