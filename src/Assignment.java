public class Assignment {
    private String description;
    private Subjects subject;

    public Assignment(String description, Subjects subject) {
        this.description = description;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "description='" + description + '\'' +
                ", subject=" + subject +
                '}';
    }
}
