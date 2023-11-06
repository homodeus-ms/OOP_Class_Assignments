package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {

    private static final int ADD_AMOUNT_IN_A_TICK = 15;
    private final ArrayList<Schedule> schedules;
    private int currScheduleIndex;

    public Sprinkler() {
        super(DeviceType.SPRINKLER);
        schedules = new ArrayList<>();
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    @Override
    public void spray(Planter planter) {
        planter.sprinkleWater();
    }

    @Override
    public void onTick() {
        ++currTick;
        ++updatedTick;

        if (currTick == 0) {
            return;
        }

        int size = schedules.size();

        // 유효한 스케쥴을 가리키게 한다
        for (int i = currScheduleIndex; i < size; ++i) {
            if (schedules.get(currScheduleIndex).getStartTick() == 0 ||
                    currTick > schedules.get(currScheduleIndex).getEndTick()) {
                ++currScheduleIndex;
            } else {
                break;
            }
        }
        // 유효한 스케쥴이 없다면
        if (currScheduleIndex == size) {
            toggled = isOn;
            isOn = false;
            return;
        }

        int startTick = schedules.get(currScheduleIndex).getStartTick();
        int endTick = schedules.get(currScheduleIndex).getEndTick();

        if (currTick == startTick) {
            toggled = !isOn;
            isOn = true;
        } else if (currTick == endTick) {
            toggled = isOn;
            isOn = false;
            ++currScheduleIndex;
        }

        updatedTick = toggled ? 0 : updatedTick;
        toggled = false;
    }


    @Override
    public void drain(Planter planter) {

    }
    @Override
    public void detect(int waterLever) {

    }
}
