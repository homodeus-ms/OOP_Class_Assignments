package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable {

    private final int REMOVE_AMOUNT_IN_A_TICK = 7;
    private final int limitWaterAmount;

    public Drainer(int waterAmount) {
        super(DeviceType.DRAINER);
        this.limitWaterAmount = waterAmount;
    }

    public int getLimitAmount() {
        return limitWaterAmount;
    }

    @Override
    public void detect(int waterLevel) {
        if (isOn != waterLevel >= limitWaterAmount) {
            toggled = true;
        }
        isOn = waterLevel >= limitWaterAmount;
    }

    @Override
    public void drain(Planter planter) {
        planter.drainWater();
    }
    @Override
    public void spray(Planter planter) {

    }

    @Override
    public void onTick() {
        ++currTick;
        ++updatedTick;

        updatedTick = toggled ? 0 : updatedTick;
        toggled = false;
    }
}
