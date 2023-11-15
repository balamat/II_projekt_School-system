import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Student {

    private Name name;
    private String uid;
    private Map<Subjects, List<Grade>> subjectAndGradeList;
    private Map<LocalDate, Boolean> absenceMapByStudent;

    public Student(Name name) {
        this.name = name;
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

    @Override
    public String toString() {
        return name.toString();

    }
}

