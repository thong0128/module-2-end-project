package controler;

import model.BasicBow;

import java.util.ArrayList;
import java.util.List;

public class BasicBow20LbsPool {
    private static final int NUMBER_OF_BASIC_BOW = 30;
    private final List<BasicBow> available = new ArrayList<>();
    private final List<BasicBow> inUse = new ArrayList<>();
    private int count;
    private int waiting;
    private final int POUNDAGE = 20;
    public void release(BasicBow basicBow) {
        inUse.remove(basicBow);
        available.add(basicBow);
    }
    public BasicBow getBasicBow() {
        if (!available.isEmpty()) {
            BasicBow basicBow = available.get(0);
            inUse.add(basicBow);
            return basicBow;
        }
        if (count == NUMBER_OF_BASIC_BOW) {
            System.out.println("No free bow");
            return null;
        }
        BasicBow basicBow = this.createBasicBow();
        inUse.add(basicBow);
        return basicBow;
    }
    private BasicBow createBasicBow() {
        BasicBow basicBow = new BasicBow(POUNDAGE);
    }

}
