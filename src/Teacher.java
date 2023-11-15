import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher implements User {

    private static List<Teacher> allTeacherList = new ArrayList<>();
    private Name name;
    private List<Subjects> taughtSubject;
    private String uid;

    public Teacher(Name name, Subjects subject1, Subjects subject2) {
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
        this.taughtSubject.add(subject2);
        this.uid = UUID.randomUUID().toString();        //MODIFY!!!!!!
        allTeacherList.add(this);
    }

    public Teacher(Name name, Subjects subject1) {
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
        this.uid = UUID.randomUUID().toString();        //MODIFY!!!!!!
        allTeacherList.add(this);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Subjects> getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(List<Subjects> taughtSubject) {
        this.taughtSubject = taughtSubject;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public static List<Teacher> getAllTeacherList() {
        return allTeacherList;
    }

    @Override
    public void login() {

    }

    @Override
    public void chooseMainFunction() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String toString() {
        return name.toString();
    }
}
