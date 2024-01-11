package model;

public class ShootingLane {
    private static int INDEX;
    private final int id;
    private PlaySession playSession;
    private boolean free = true;

    public ShootingLane() {
        this.id = INDEX++;
    }

    public ShootingLane(PlaySession playSession) {
        this.id = INDEX++;
        this.playSession = playSession;
        this.free = false;
    }

    public ShootingLane(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public PlaySession getPlaySession() {
        return playSession;
    }

    public void setPlaySession(PlaySession playSession) {
        this.playSession = playSession;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "ShootingLane{" +
                "id=" + id +
                ", playSession=" + playSession +
                ", free=" + free +
                '}';
    }
}
