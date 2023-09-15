package academy.pocu.comp2500.assignment1;

public class Article {
    protected User author;
    protected String body;

    public Article(User user, String body) {
        this.author = user;
        this.body = body;
    }
    public User getUser() {
        return author;
    }
    public String getBody() {
        return body;
    }
    protected void setBody(String body) {
        this.body = body;
    }
}
