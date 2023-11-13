import java.util.List;
import java.util.UUID;

public class Teacher extends User {
    Name name;
    Subject subject;
    String uid;

    public Teacher(Name name, Subject subject) {
        this.name = name;
        this.subject = subject;
        this.uid = UUID.randomUUID().toString();        //MODIFY!!!!!!
    }


    @Override
    public void login() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void logout() {

    }
}
