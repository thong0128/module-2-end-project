package model;

public abstract class Bow {
    private static int INDEX;
    private int id;
    private Color color;
    private int poundage;

    Bow() {
    }

    Bow(Color color, int poundage) {
        this.id = ++INDEX;
        this.color = color;
        this.poundage = poundage;
    }

    Bow(int poundage) {
        this.poundage = poundage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPoundage() {
        return poundage;
    }

    public void setPoundage(int poundage) {
        this.poundage = poundage;
    }
    public abstract int getPrice();

    @Override
    public String toString() {
        return "Bow{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", poundage=" + poundage +
                '}';
    }
}