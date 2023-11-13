import java.util.ArrayList;
import java.util.List;

public enum Subject {
    MATHS("Matematika"),
    HUNGARIAN("Magyar"),
    ENGLISH("Angol"),
    GERMAN("Német"),
    HISTORY("Történelem"),
    PHYSICS("Fizika"),
    VISUAL_ARTS("Rajz"),
    MUSIC("Ének"),
    SPORT("Testnevelés"),
    ;

    Subject(String subjectName) {
        this.subjectName = subjectName;

    }

    private String subjectName;


}