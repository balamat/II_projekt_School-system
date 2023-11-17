import java.time.LocalDate;
import java.util.*;

public class Student {

    private StudClass studClass;
    private Name name;
    private String uid;
    private Map<Subjects, List<Grade>> subjectAndGradeList;
    private Map<LocalDate, String> absenceMapByStudent;

    public Student(Name name, StudClass studClass) {
        this.name = name;
        this.studClass = studClass;
        this.studClass.getStudentList().add(this);
        this.uid = UUID.randomUUID().toString();            //MODIFY!!!!!!
        this.subjectAndGradeList = new HashMap<>();
        this.absenceMapByStudent = new HashMap<>();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Map<Subjects, List<Grade>> getSubjectAndGradeList() {
        return subjectAndGradeList;
    }

    public void setSubjectAndGradeList(Map<Subjects, List<Grade>> subjectAndGradeList) {
        this.subjectAndGradeList = subjectAndGradeList;
    }

    public Map<LocalDate, String> getAbsenceMapByStudent() {
        return absenceMapByStudent;
    }

    public void setAbsenceMapByStudent(Map<LocalDate, String> absenceMapByStudent) {
        this.absenceMapByStudent = absenceMapByStudent;
    }

    public StudClass getStudClass() {
        return studClass;
    }

    public void setStudClass(StudClass studClass) {
        this.studClass = studClass;
    }

    public void addGrade(Subjects subject, String[] grades) {
        if (!this.getSubjectAndGradeList().containsKey(subject)) {
            this.getSubjectAndGradeList().put(subject, new ArrayList<Grade>());
        }
        this.getSubjectAndGradeList().get(subject).add(new Grade(grades[0], Integer.parseInt(grades[1])));
//        this.getSubjectAndGradeList().getOrDefault(subject, new ArrayList<Grade>()).add(new Grade(grades[0], Integer.parseInt(grades[1])));
    }

    @Override
    public String toString() {
        return "Student{" +
                "studClass=" + studClass +
                ", name=" + name +
                ", subjectAndGradeList=" + subjectAndGradeList.entrySet() +
                ", absenceMapByStudent=" + absenceMapByStudent.entrySet() +
                '}';
    }
}

