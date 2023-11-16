public class Grade {
    private Assignment assignment;
    private int grade;

    public Grade(Assignment assignment, int grade) {
        this.assignment = assignment;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "assignment=" + assignment +
                ", grade=" + grade +
                '}';
    }
}
