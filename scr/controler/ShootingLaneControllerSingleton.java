package controler;

import model.PlaySession;
import model.ShootingLane;

import java.util.ArrayList;
import java.util.List;

public class ShootingLaneControllerSingleton implements Alertable {
    private static final int NUMBER_OF_LANE = 20;
    public static List<ShootingLane> laneList = new ArrayList<>();
    public static List<ShootingLane> inUse = new ArrayList<>();
    public static ShootingLaneControllerSingleton instance;

    private ShootingLaneControllerSingleton() {
        for (int i = 0; i < NUMBER_OF_LANE; i++) {
            ShootingLane lane = new ShootingLane();
            laneList.add(lane);
        }
    }
    public static ShootingLaneControllerSingleton getInstance() {
        if (instance == null) {
            instance = new ShootingLaneControllerSingleton();
        }
        return instance;
    }

    public void getLane(PlaySession playSession) {
        if (inUse.size() == NUMBER_OF_LANE) {
            alert("No lane avaiable");
        }else {
            for (ShootingLane lane : laneList) {
                if (lane.isFree()) {
                    lane.setPlaySession(playSession);
                    lane.setFree(false);
                    inUse.add(lane);
                    alert("Lane " + lane.getId() + " is assigned to " + lane.getPlaySession());
                    return;
                }
            }
        }
    }
    public void getLane(int id, PlaySession playSession) {
        for (ShootingLane lane : laneList) {
            if (lane.getId() == id && lane.isFree()) {
                lane.setPlaySession(playSession);
                lane.setFree(false);
                inUse.add(lane);
                alert("Lane " + lane.getId() + " is assigned to " + lane.getPlaySession());
                return;
            }
        }
        alert("Lane " + id + " is not available");
    }

    public void releaseLane(int id) {
        for (ShootingLane lane : inUse) {
            if (lane.getId() == id) {
                inUse.remove(lane);
                lane.setPlaySession(null);
                lane.setFree(true);
                return;
            }
        }
        alert("Lane " + id + " is not occupies");
    }
    public void releaseLane(ShootingLane shootingLane) {
        inUse.remove(shootingLane);
        shootingLane.setPlaySession(null);
        shootingLane.setFree(true);
    }
    public ShootingLane getActiveLaneById(int id) {
        for (ShootingLane lane : inUse) {
            if (lane.getId() == id) {
                return lane;
            }
        }
        alert("Lane " + id + " is not active");
        return null;
    }

    @Override
    public void alert(String mess) {
        System.out.println(mess);
    }
}
