package academy.pocu.comp2500.lab8;

public class Schedule {

    private final int startTick;
    private final int endTick;
    //private final int duration;

    public Schedule(final int startTick, final int duration) {
        this.startTick = startTick;
        this.endTick = startTick + duration;
        //this.duration = duration;
    }

    public int getStartTick() {
        return startTick;
    }
    public int getEndTick() {
        return endTick;
    }
}
