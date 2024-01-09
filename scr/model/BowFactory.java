package model;

public class BowFactory {
    public Bow getBow(BowType bowType, Color color, int poundage) {
        if (bowType == BowType.BASIC_BOW) {
            return new BasicBow(color, poundage);
        } else if (bowType == BowType.TRADITIONAL_BOW) {
            return new TraditionalBow(color, poundage);
        }
        return null;
    }
    public Bow getBow(BowType bowType, int poundage) {
        if (bowType == BowType.BASIC_BOW) {
            return new BasicBow(poundage);
        } else if (bowType == BowType.TRADITIONAL_BOW) {
            return new TraditionalBow(poundage);
        }
        return null;
    }
}
