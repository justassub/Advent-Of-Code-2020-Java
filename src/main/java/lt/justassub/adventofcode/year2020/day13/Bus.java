package lt.justassub.adventofcode.year2020.day13;

public class Bus {
    int busId;
    int delay;

    public Bus(int busId, int delay) {
        this.busId = busId;
        this.delay = delay;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
