package fr.rover;

/**
 *
 */
public class Rover {

    private int x;
    private int y;

    private Cardinality direction;


    public Rover(int x, int y, Cardinality direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Rover(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cardinality getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Cardinality direction) {
        this.direction = direction;
    }
}
