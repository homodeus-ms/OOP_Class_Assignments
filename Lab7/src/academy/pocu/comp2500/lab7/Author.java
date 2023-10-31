package academy.pocu.comp2500.lab7;

public final class Author {

    private final String firstName;
    private final String lastName;

    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Author)) {
            return false;
        }
        Author a = (Author) obj;
        return firstName.equals(a.firstName) && lastName.equals(a.lastName);
    }

    @Override
    public int hashCode() {    // 65599 해쉬함수
        int hash = 0;
        String fullName = firstName + lastName;
        int length = fullName.length();
        for (int i = 0; i < length; ++i) {
            hash = 65599 * hash + fullName.charAt(i);
        }
        return hash ^ (hash >> 16);
    }

}
