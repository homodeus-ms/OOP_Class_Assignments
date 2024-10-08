package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public final class Planter {

    private final int USE_AMOUNT_IN_A_TICK = 2;
    private final int ADD_AMOUNT_IN_A_TICK = 15;
    private final int REMOVE_AMOUNT_IN_A_TICK = 7;
    
    private int currWaterAmount;
    private final ArrayList<SmartDevice> devices;


    public Planter(final int remainWater) {
        currWaterAmount = remainWater;
        devices = new ArrayList<>();
    }

    public int getWaterAmount() {
        return currWaterAmount;
    }
    public void sprinkleWater() {
        currWaterAmount += ADD_AMOUNT_IN_A_TICK;
    }
    public void drainWater() {
        currWaterAmount = Math.max(0, currWaterAmount - REMOVE_AMOUNT_IN_A_TICK);
    }

    public void installSmartDevice(SmartDevice device) {
        devices.add(device);
    }

    public void tick() {
        for (SmartDevice s : devices) {
            s.detect(currWaterAmount);
            s.onTick();
        }

        currWaterAmount -= USE_AMOUNT_IN_A_TICK;

        for (SmartDevice s : devices) {

            if (s.isOn()) {
                s.spray(this);
                s.drain(this);
            }
        }

        currWaterAmount = Math.max(0, currWaterAmount);
    }
}
