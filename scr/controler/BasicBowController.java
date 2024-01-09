package controler;

import model.BasicBow;

import java.util.ArrayList;
import java.util.List;

public class BasicBowController {
    public static List<BasicBow> basicBowList = new ArrayList<>();
    public static void addNewBasicBow(BasicBow basicBow) {
        basicBowList.add(basicBow);
    }
    public static void deleteByID(int id){
        for (BasicBow basicBow:basicBowList){
            if (basicBow.getId()==id){
                basicBowList.remove(basicBow);
                return;
            }
        }
        System.out.println("No bow with id: " + id);
    }

}
