package model;

public class TraditionalBow extends Bow {
    private static final int PRICE = 150000;

    TraditionalBow() {
    }

    TraditionalBow(Color color, int poundage) {
        super(color, poundage);
    }

    TraditionalBow(int poundage) {
        super(poundage);
        setColor(Color.DEFAULT);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "TraditionalBow{" +
                "price=" + PRICE +
                "} " + super.toString();
    }
}
