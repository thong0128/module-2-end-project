package controler;

import model.Arrow;
import model.Color;

import java.util.ArrayList;
import java.util.List;

public class ArrowController {
    public static List<Arrow> arrowList = new ArrayList<>();

    public ArrowController() {
    }

    public List<Arrow> getArrowList() {
        return arrowList;
    }

    public void setArrowList(List<Arrow> arrowList) {
        ArrowController.arrowList = arrowList;
    }

    public ArrowController(List<Arrow> arrowList) {
        ArrowController.arrowList = arrowList;
    }

    public static void addArrow(Arrow arrow) {
        arrowList.add(arrow);
    }
    public static void addArrows(int num, int spine){
        for (int i = 0; i < num; i++) {
            Arrow arrow = new Arrow(spine);
        }
    }
    public static void addArrows(int num, int spine, Color color){
        for (int i = 0; i < num; i++) {
            Arrow arrow = new Arrow(spine, color);
        }
    }
    public static void deleteArrow(int num){
        if (num > 0) {
            arrowList.subList(0, num).clear();
        }
    }
}
