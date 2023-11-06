package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public abstract class SmartDevice {

    protected final DeviceType deviceType;
    protected int currTick;
    protected int updatedTick;
    protected boolean isOn;
    protected boolean toggled;


    protected SmartDevice(final DeviceType deviceType) {
        this.deviceType = deviceType;

    }
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public boolean isOn() {
        return isOn;
    }

    public abstract void spray(Planter planter);
    public abstract void drain(Planter planter);
    public abstract void detect(int waterLever);

    public void onTick() {
        ++currTick;
        ++updatedTick;

        updatedTick = toggled ? 0 : updatedTick;
        toggled = false;
    }

    public int getTicksSinceLastUpdate() {
        return updatedTick;
    }
}
