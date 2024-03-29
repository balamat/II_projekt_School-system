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
                if (localdate.isAfter(Log.actualDate)) {
                    throw new DataException();
                } else if (localdate.isBefore(Log.actualDate.minusYears(1)) && Log.permission != 0) {
                    throw new PermissionException();
                } else {
                    return localdate;
                }
            } catch (DateTimeParseException e) {
                isWrongInput = true;
                System.out.println("A megadott idő formátuma nem megfelelő!");
            } catch (DataException e) {
                isWrongInput = true;
                System.out.println("Nem lehet jövőbeli időt megadni!");
            } catch (PermissionException e) {
                isWrongInput = true;
                System.out.println("Admin jogosultság szükséges: 1 évnél régebbi óra!!");
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
            String similarStudent = "";
            try {
                String inputStudent = studentNameValidator();
//                String inputStudent = UserInterface.studentScan();
                similarStudent = inputStudent;
                Student student = Student.getAllStudentList().stream().filter(stud -> stud.getName().toString().equals(inputStudent)).findFirst().orElseThrow();
                return student;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("Nincs ilyen nevű diák az iskolában!");
                System.out.println(similarStudent);
                UserInterface.printSimilarStudents(similarStudent);
            }
        } while (isWrongInput);
        return null;
    }

    public static ClassDiary classDiarySearch() {
        do {
            try {
                isWrongInput = false;
                LocalDate localDate = dateSearch();
                ClassSerial classSerial = classSerialSearch();
                ClassDiary classDiary = ClassDiary.getAllClassDiary().stream()
                        .filter(cd -> cd.getDate().equals(localDate))
                        .filter(cd -> cd.getClassSerial().equals(classSerial))
                        .findFirst().orElseThrow();
                return classDiary;
            } catch (NoSuchElementException e) {
                isWrongInput = true;
                System.out.println("A megadott óra még nincs bekönyvelve!");
            }
        } while (isWrongInput);
        return null;
    }

    public static String studentNameValidator() {
        do {
            try {
                String name = UserInterface.studentScan();

                if (name.isEmpty() || name.length() < 2) {
                    throw new DataException("Túl rövid név!");
                }
                String[] dividedName = name.split(" ");
                for (String namepart : dividedName
                ) {
                    if (namepart.substring(0, 1).equals(namepart.substring(0, 1).toLowerCase())) {
                        throw new DataException("Nem nagybetűvel kezdődik!");
                    }
                }
                return name;
            } catch (DataException e) {
                isWrongInput = true;
                System.out.println("Nem megfelelő a megadott formátum!");
            }
        } while (isWrongInput);
        return null;
    }

    public static String newStudClassNameValidator() {
        do {
            try {
                String name = UserInterface.generalScan();
                if (name.length() < 2 || name.length() > 3 || !Character.isDigit(name.charAt(0)) || Character.isDigit(name.charAt(name.length() - 1))) {
                    throw new DataException("Túl rövid név!");
                }
                if (!name.toUpperCase().equals(name)) {
                    throw new DataException("Nem a mintának megfelelő formátum!");
                }
                return name;
            } catch (DataException e) {
                isWrongInput = true;
                System.out.println("Nem megfelelő a megadott formátum!");
            }
        } while (isWrongInput);
        return null;
    }

    public static int numberOfAbsentValidator(StudClass studClass) {
        int numberOfAbsent = 0;
        do {
            try {
                //reset the inputValidator to its original state
                isWrongInput = false;
                numberOfAbsent = Integer.parseInt(UserInterface.numberOfAbsentScan());
                if (numberOfAbsent > Student.getAllStudentList().stream().filter(student -> student.getStudClassString().equals(studClass.getNameOfClass())).count()) {
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
        return numberOfAbsent;
    }

    public static int choiceValidator(int numberOfOptions) {
        int choice = 0;
        do {
            try {
                //reset the inputValidator to its original state
                isWrongInput = false;
                choice = UserInterface.choiceScan();
                if (choice > numberOfOptions || choice < 0) {
                    throw new MenuExcpetion();
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Nem számot adtál meg! Válassz az előbbi lehetőségek közül!");
                isWrongInput = true;
            } catch (MenuExcpetion e) {
                System.out.println("Nincs ilyen menüpont! Válassz az előbbi lehetőségek közül!");
                isWrongInput = true;
            }
        } while (isWrongInput);
        return choice;
    }

    public static int gradeValidator() {
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
        return grade;
    }

}
