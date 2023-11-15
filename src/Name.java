public class Name {
    private String firstName;
    private String lastName;

    public Name(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
