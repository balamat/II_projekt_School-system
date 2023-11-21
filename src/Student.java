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

    public Student(Name name, String studClassString) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = generateRandomDate();
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
        Student.getAllStudentList().add(this);
    }

    public Student(Name name, String studClassString, String birthday) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = LocalDate.parse(birthday);
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
        Student.getAllStudentList().add(this);
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static LocalDate generateRandomDate() {
        long minDay = LocalDate.of(2009, 8, 31).toEpochDay();
        long maxDay = LocalDate.of(2013, 9, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }


    @Override
    public String toString() {
        return "Student{" +
                "studClass=" + studClassString +
                ", name=" + name +
                ", uuid='" + uuid + '\'' +
                ", subjectAndGradeList=" + subjectAndGradeList +
                '}';
    }
}

