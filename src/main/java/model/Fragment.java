package model;

public class Fragment {
    private int coordinateX;
    private int coordinateY;
    private int dimensionX;
    private int dimensionY;

    public Fragment(int coordinateX, int coordinateY, int dimensionX, int dimensionY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

}
