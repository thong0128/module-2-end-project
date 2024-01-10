package controler;

import model.Arrow;
import model.BasicBow;

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

    public static void addArrows(int num) {
        arrowList.add(basicBow);
    }
    public static void deleteByID(int id){
        for (BasicBow basicBow: arrowList){
            if (basicBow.getId()==id){
                arrowList.remove(basicBow);
                return;
            }
        }
        System.out.println("No bow with id: " + id);
    }
}
