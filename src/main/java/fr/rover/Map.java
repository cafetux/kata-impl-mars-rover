package fr.rover;

import fr.rover.coordonnee.Coordonnee;

/**
 * Created by fmaury on 15/08/16.
 */
public class Map {

    private Obstacles obstacles;

    public Map(Obstacles obstacles) {
        this.obstacles = obstacles;
    }

    public boolean isAvailable(Coordonnee position) {
        return !obstacles.existOn(position);
    }
}
