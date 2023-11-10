package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {

    protected int currTick;
    protected int updatedTick;
    protected boolean isOn;
    protected boolean toggled;

    public boolean isOn() {
        return isOn;
    }

    public void spray(Planter planter) {
    }
    public void drain(Planter planter) {
    }
    public void detect(int waterLever) {
    }

    public abstract void onTick();

    public int getTicksSinceLastUpdate() {
        return updatedTick;
    }
}
