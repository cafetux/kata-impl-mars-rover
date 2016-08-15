package fr.rover;

import fr.rover.coordonnee.Coordonnee;

/**
 *
 */
public class Rover {

    private Coordonnee position;
    private Cardinality direction;


    public Rover(int x, int y, Cardinality direction) {
        this.position = new Coordonnee(x, y);
        this.direction = direction;
    }

    public Rover() {
        this.position=new Coordonnee(0,0);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Cardinality getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void setDirection(Cardinality direction) {
        this.direction = direction;
    }
}
