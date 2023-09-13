package academy.pocu.comp2500.assignment1;

public class UserNumberFactory {
    private int num;
    public UserNumberFactory() {
        this.num = 0;
    }
    public int getNumber() {
        return this.num;
    }
    public void increaseNum() {
        ++this.num;
    }
}
