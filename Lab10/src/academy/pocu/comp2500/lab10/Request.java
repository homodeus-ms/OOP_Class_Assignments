package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private String title;
    private User user;

    public Request(String title) {
        this.title = title;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Request) ||
                this.hashCode() != obj.hashCode()) {
            return false;
        }
        Request other = (Request) obj;
        if (user == null) {
            return this.title.equals(other.getTitle());
        }
        return this.title.equals(other.getTitle()) && this.user.equals(other.getUser());
    }
    @Override
    public int hashCode() {
        int code = this.user == null ? 1 : this.user.hashCode();
        return (this.title.hashCode() + code) ^ (code << 16);
    }
}
