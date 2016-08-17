package fr.rover;

import fr.rover.coordonnee.Coordonnee;
import fr.rover.obstacle.Obstacles;

/**
 * Created by fmaury on 15/08/16.
 */
public class Map {

    private final EdgesLinks links;
    private final Obstacles obstacles;

    public Map(Obstacles obstacles, EdgesLinks links) {
        this.obstacles = obstacles;
        this.links=links;
    }

    public Map(Obstacles obstacles) {
        this(obstacles,new EdgesLinks());
    }

    public boolean isAvailable(Coordonnee position) {
        return !obstacles.isPresent(position);
    }

    public Coordonnee getRealposition(Coordonnee theoricPosition){
        return links.getDestinationEdgeFrom(theoricPosition).orElse(theoricPosition);
    }
}
