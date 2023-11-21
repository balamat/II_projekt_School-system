import java.time.LocalDate;
import java.util.*;

public class Student {

    private final UUID uuid;
    private static List<Student> allStudentList = new ArrayList<>();
    private String studClassString;
    private Name name;
    private Map<Subjects, List<Grade>> subjectAndGradeList;

    public Student(Name name, String studClassString) {
        this.uuid = UUID.randomUUID();
        this.name = name;
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

    public void addGrade(Subjects subject, String[] grades) {
        if (!this.getSubjectAndGradeList().containsKey(subject)) {
            this.getSubjectAndGradeList().put(subject, new ArrayList<Grade>());
        }
        this.getSubjectAndGradeList().get(subject).add(new Grade(grades[0], Integer.parseInt(grades[1])));
    }

    public static List<Student> getAllStudentList() {
        return allStudentList;
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

