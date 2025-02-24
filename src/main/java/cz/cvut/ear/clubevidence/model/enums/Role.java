package cz.cvut.ear.clubevidence.model.enums;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    PREMIUM_USER("PREMIUM_USER");
    private final String name;
    Role(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}
