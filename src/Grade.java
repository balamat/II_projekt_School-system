public class Grade {
    private String description;
    private int grade;

    public Grade(String description, int grade) {
        this.description = description;
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
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
