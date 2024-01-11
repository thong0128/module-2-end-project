package model;

public class BasicBow extends Bow {
    private static final int PRICE = 100000;
    public BasicBow() {
    }

    public BasicBow(Color color, int poundage) {
        super(color, poundage);
    }

    public BasicBow(int poundage) {
        super(poundage);
        setColor(Color.BLACK);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "BasicBow{" +
                "price=" + PRICE +
                "} " + super.toString();
    }

}
