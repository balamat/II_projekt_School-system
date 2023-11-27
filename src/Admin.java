import java.util.UUID;

public class Admin implements Cloneable, User{

    private final UUID uuid;
    private Name name;

    public Admin(Name name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Admin clone() {
        try {
            return (Admin) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
