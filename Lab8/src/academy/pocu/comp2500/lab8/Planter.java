package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    // tick마다 2L 소비
    private final int USE_AMOUNT_IN_A_TICK = 2;
    private final int ADD_AMOUNT_IN_A_TICK = 15;
    private final int REMOVE_AMOUNT_IN_A_TICK = 7;
    private int currWaterAmount;

    private final ArrayList<SmartDevice> devices;
    /*private final ArrayList<SmartDevice> sprinklers;
    private final ArrayList<SmartDevice> drainers;*/

    public Planter(int remainWater) {
        currWaterAmount = remainWater;
        devices = new ArrayList<>();
        /*sprinklers = new ArrayList<>();
        drainers = new ArrayList<>();*/
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
        /*if (device.getDeviceType() == DeviceType.SPRINKLER) {
            sprinklers.add(device);
        } else {
            drainers.add(device);
        }*/
        devices.add(device);
    }

    public void tick() {
        for (SmartDevice s : devices) {

            if (s.getDeviceType() == DeviceType.DRAINER) {
                s.detect(currWaterAmount);
            }

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
