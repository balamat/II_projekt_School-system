import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Menu {

    //initial value
    public static boolean isWrongInput = false;

    public static LocalDate dateSearch() {
        do {
            try {
                LocalDate localdate = LocalDate.parse(UserInterface.dateScan());
                return localdate;
            } catch (DateTimeParseException e) {
                isWrongInput = true;
                System.out.println("A megadott idő formátuma nem megfelelő!");
            }
        }
        while (isWrongInput);
        return null;
    }

    public static ClassSerial classSerialSearch() {
        do {
            try {
                int classSerialInt = Integer.parseInt(UserInterface.classSerialScan());
                ClassSerial classSerial = ClassSerial.values()[classSerialInt - 1];
                return classSerial;
            } catch (NumberFormatException e) {
                isWrongInput = true;
                System.out.println("Nem számot adtál meg!");
            } catch (ArrayIndexOutOfBoundsException e) {
                isWrongInput = true;
                System.out.println("A megadott szám nem esik az 1-9 tartományba!");
            }
        }
        while (isWrongInput);
        return null;
    }

    public static Subjects subjectSearch() {
        do {
            try {
                String inputSubject = UserInterface.subjectScan();
                Subjects subject = Arrays.stream(Subjects.values()).filter(sb -> sb.getSubjectName().toLowerCase().equals(inputSubject.toLowerCase())).findFirst().orElseThrow();
                return subject;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen tantárgy!");
            }
        } while (isWrongInput);
        return null;
    }

    public static StudClass studClassSearch() {
        do {
            try {
                String inputStudClass = UserInterface.studClassScan();
                StudClass studClass = StudClass.getAllStudClassList().stream().filter(cl -> cl.getNameOfClass().equals(inputStudClass)).findFirst().orElseThrow();
                return studClass;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen osztály!");
            }
        } while (isWrongInput);
        return null;
    }

    public static Teacher teacherSearch() {
        do {
            try {
                String inputTeacher = UserInterface.teacherScan();
                Teacher teacher = Teacher.getAllTeacherList().stream().filter(tch -> tch.getName().toString().equals(inputTeacher)).findFirst().orElseThrow();
                return teacher;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen nevű tanár az iskolában!");
            }
        } while (isWrongInput);
        return null;
    }

    /**
     * Search according to the student's StudClass
     *
     * @return
     */
    public static Student studentSearch() {
        do {
            try {
                String inputStudent = UserInterface.studentScan();
                Student student = Student.getAllStudentList().stream().filter(stud -> stud.getName().toString().equals(inputStudent)).findFirst().orElseThrow();
                return student;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen nevű diák az iskolában!");
            }
        } while (isWrongInput);
        return null;
    }

    public static Student studentSearchByUuid(String inputUuid) {
        Student student = Student.getAllStudentList().stream().filter(stud -> stud.getUuid().toString().equals(inputUuid)).findFirst().orElseThrow();
        return student;
    }

    public static ClassDiary fillClassDiary() {
        String labelOfAction = "aktuális óra naplózása";
        System.out.println(labelOfAction.toUpperCase());
        LocalDate localDate = dateSearch();
        ClassSerial classSerial = classSerialSearch();
        Subjects subject = subjectSearch();
        Teacher teacher = teacherSearch();
        StudClass studClass = studClassSearch();
        int numberOfAbsent = 0;

        do {
            try {
                //reset the inputValidator to its original state
                isWrongInput = false;
                numberOfAbsent = Integer.parseInt(UserInterface.numberOfAbsentScan());
                if (numberOfAbsent > studClass.getStudentList().size()) {
                    throw new DataException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Nem számot adtál meg!");
                isWrongInput = true;
            } catch (DataException e) {
                System.out.println("Nem lehet a hiányzók száma az osztálylétszámnál nagyobb!");
                isWrongInput = true;
            }
        } while (isWrongInput);

        ClassDiary classDiary = new ClassDiary(localDate, classSerial, subject, teacher, studClass).addAbsentStudent(numberOfAbsent);
        UserInterface.printObject(classDiary);
        UserInterface.printSuccesfullyTerminated(labelOfAction);
        return classDiary;
    }

    public static void modifyClassDiary() {
        String labelOfAction = "meglévő naplóadatok módosítása";
        UserInterface.printSuccesfullyTerminated(labelOfAction);
    }

    public static void saveGrade() {
        String labelOfAction = "jegy beírása";
        System.out.println(labelOfAction.toUpperCase());
        Student student = Menu.studentSearch();
        Subjects subject = Menu.subjectSearch();
        String description = UserInterface.gradeDescriptionScan();
        int grade = 0;

        do {
            try {
                //reset the inputValidator to its original state
                isWrongInput = false;
                grade = Integer.parseInt(UserInterface.gradeScan());
                if (grade > 5 || grade < 1) {
                    throw new DataException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Nem számot adtál meg!");
                isWrongInput = true;
            } catch (DataException e) {
                System.out.println("A megadott szám nem jegy (1-5 közötti)!");
                isWrongInput = true;
            }
        } while (isWrongInput);

        student.addGrade(subject, description, grade);
        UserInterface.printSuccesfullyTerminated(labelOfAction);
    }


}
