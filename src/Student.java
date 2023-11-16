import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Student {

    private StudClass studClass;
    private Name name;
    private String uid;
    private Map<Subjects, List<Grade>> subjectAndGradeList;
    private Map<LocalDate, Boolean> absenceMapByStudent;

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

    public Map<LocalDate, Boolean> getAbsenceMapByStudent() {
        return absenceMapByStudent;
    }

    public void setAbsenceMapByStudent(Map<LocalDate, Boolean> absenceMapByStudent) {
        this.absenceMapByStudent = absenceMapByStudent;
    }

    public StudClass getStudClass() {
        return studClass;
    }

    public void setStudClass(StudClass studClass) {
        this.studClass = studClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studClass=" + studClass +
                ", name=" + name +
                ", subjectAndGradeList=" + subjectAndGradeList +
                ", absenceMapByStudent=" + absenceMapByStudent +
                '}';
    }
}

