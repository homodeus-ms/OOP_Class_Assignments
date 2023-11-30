package academy.pocu.comp2500.lab11;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(User user) throws IllegalAccessException {
        super(user);
    }
    @Override
    public boolean deposit(final int amount) {
        int beforeAmount = getAmount();
        if (beforeAmount < 0) {
            throw new OverflowException("Overflow");
        }
        int afterAmount = beforeAmount + amount;

        if (amount > 0 && beforeAmount > afterAmount) {
            throw new OverflowException("Overflow");
        }

        return super.deposit(amount);
    }
}
