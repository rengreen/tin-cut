package model;

public class Cut {

    private String orientation;
    private int position;
    private int cost;

    public Cut(String orientation, int position, int cost) {
        this.orientation = orientation;
        this.position = position;
        this.cost = cost;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
