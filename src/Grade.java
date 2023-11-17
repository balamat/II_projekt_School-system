public class Grade {
    private String description;
    private int grade;

    public Grade(String description, int grade) {
        this.description = description;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "description='" + description + '\'' +
                ", grade=" + grade +
                '}';
    }
}
