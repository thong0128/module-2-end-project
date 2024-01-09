package model;

public class Arrow {
    private int spine;
    private Color color;

    public Arrow() {
    }

    public Arrow(int spine, Color color) {
        this.spine = spine;
        this.color = color;
    }

    public int getSpine() {
        return spine;
    }

    public void setSpine(int spine) {
        this.spine = spine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Arrow{" +
                "spine=" + spine +
                ", color=" + color +
                '}';
    }
}
