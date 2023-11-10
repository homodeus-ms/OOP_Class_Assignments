package academy.pocu.comp2500.lab8;

public final class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {

    private final int limitWaterAmount;

    public Drainer(final int waterAmount) {
        this.limitWaterAmount = waterAmount;
    }

    public int getLimitAmount() {
        return limitWaterAmount;
    }

    @Override
    public void detect(final int waterLevel) {
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
    public void onTick() {
        ++currTick;
        ++updatedTick;

        updatedTick = toggled ? 0 : updatedTick;
        toggled = false;
    }
}
