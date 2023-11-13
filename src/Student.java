import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Student {

    Name name;
    String uid;
    Map<Subject, List<Grade>> subjectAndGradeList;
    Map<LocalDate, Boolean> absenceMapByStudent;

    public Student(Name name) {
        this.name = name;
        this.uid = UUID.randomUUID().toString();            //MODIFY!!!!!!
        this.subjectAndGradeList = subjectAndGradeList;
        this.absenceMapByStudent = absenceMapByStudent;
    }
}
