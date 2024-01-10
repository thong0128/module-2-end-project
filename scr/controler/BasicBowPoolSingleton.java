package controler;

import model.BasicBow;


import java.util.ArrayList;
import java.util.List;




public class BasicBowPoolSingleton implements Alertable{
    private static final int NUMBER_OF_BASIC_BOW = BasicBowController.basicBowList.size();
    private final List<BasicBow> available = BasicBowController.basicBowList;
    private final List<BasicBow> inUse = new ArrayList<>();
    public BasicBowPoolSingleton instance;

    private BasicBowPoolSingleton() {
    }

    private BasicBowPoolSingleton(BasicBowPoolSingleton instance) {
        this.instance = instance;
    }

    public BasicBowPoolSingleton getInstance() {
        if (instance == null) {
            return new BasicBowPoolSingleton();
        }
        return instance;
    }

    public void release(BasicBow basicBow) {
        inUse.remove(basicBow);
        available.add(basicBow);
        alert("Return " + basicBow);
    }
    public BasicBow getBasicBow(int poundage) {
        if (!available.isEmpty()) {
            for (BasicBow bow : available) {
                if (bow.getPoundage() == poundage) {
                    available.remove(bow);
                    inUse.add(bow);
                    alert("Rent out " + bow);
                    return bow;
                }
            }
        }
        alert("No bow available");
        return null;
    }

    public List<BasicBow> getAvailable() {
        return available;
    }

    public List<BasicBow> getInUse() {
        return inUse;
    }

    @Override
    public void alert(String mess) {
        System.out.println("mess");
    }
}
