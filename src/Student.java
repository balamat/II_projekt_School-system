import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Student {

    private final UUID uuid;
    private Name name;
    private LocalDate birthday;
    private String studClassString;
    private Map<Subjects, List<Grade>> subjectAndGradeList;
    private static List<Student> allStudentList = new ArrayList<>();
    private static List<Student> archivedStudentList = new ArrayList<>();

    public Student(Name name, String studClassString) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = generateRandomDate();
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
    }

    public Student(Name name, String studClassString, LocalDate birthday) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
    }

    public Student addToList() {
        allStudentList.add(this);
        return this;
    }

    public void archive() {
        allStudentList.remove(this);
        archivedStudentList.add(this);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Map<Subjects, List<Grade>> getSubjectAndGradeList() {
        return subjectAndGradeList;
    }

    public void setSubjectAndGradeList(Map<Subjects, List<Grade>> subjectAndGradeList) {
        this.subjectAndGradeList = subjectAndGradeList;
    }

    public String getStudClassString() {
        return studClassString;
    }

    public void setStudClassString(String studClassString) {
        this.studClassString = studClassString;
    }

    public void addGrade(Subjects subject, String description, int grade) {
        if (!this.getSubjectAndGradeList().containsKey(subject)) {
            this.getSubjectAndGradeList().put(subject, new ArrayList<Grade>());
        }
        this.getSubjectAndGradeList().get(subject).add(new Grade(description, grade));
    }

    public static List<Student> getAllStudentList() {
        return allStudentList;
    }

    public static List<Student> getArchivedStudentList() {
        return archivedStudentList;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    //////////////////////////////////
    public double gradeInspector() {
        return 0;
    }

    public static LocalDate generateRandomDate() {
        long minDay = LocalDate.of(2007, 8, 31).toEpochDay();
        long maxDay = LocalDate.of(2013, 9, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @Override
    public String toString() {
        return "Személyi adatok:" + System.lineSeparator() +
                "\t Név: " + name + System.lineSeparator() +
                "\t UserID: " + uuid + System.lineSeparator() +
                "\t születési idő: " + birthday + System.lineSeparator() +
                "\t Osztály: " + studClassString + System.lineSeparator();
    }
}

