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
        boolean bDeposit = super.deposit(amount);
        if (beforeAmount > getAmount()) {
            throw new OverflowException("Overflow!");
        }
        return bDeposit;
    }
}
