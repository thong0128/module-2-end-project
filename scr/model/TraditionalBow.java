package model;

public class TraditionalBow extends Bow{
    private final int price = 150000;

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
        return price;
    }

    @Override
    public String toString() {
        return "TraditionalBow{" +
                "price=" + price +
                "} " + super.toString();
    }
}
