package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {

    private final ArrayList<Schedule> schedules;
    private int currScheduleIndex;

    public Sprinkler() {
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

        checkSchedule();

        updatedTick = toggled ? 0 : updatedTick;
        toggled = false;
    }

    private void checkSchedule() {

        int size = schedules.size();

        if (currTick == 0 || currScheduleIndex >= size) {
            return;
        }

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

        if (currTick == schedules.get(currScheduleIndex).getStartTick()) {
            toggled = !isOn;
            isOn = true;
        } else if (currTick == schedules.get(currScheduleIndex).getEndTick()) {
            toggled = isOn;
            isOn = false;
            ++currScheduleIndex;
        }
    }
}
