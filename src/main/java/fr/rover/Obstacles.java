package fr.rover;

import fr.rover.coordonnee.Coordonnee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmaury on 15/08/16.
 */
public class Obstacles {

    private List<Coordonnee> obstaclesPosition = new ArrayList<>();

    public boolean add(Coordonnee obstaclePosition){
        return obstaclesPosition.add(obstaclePosition);
    }


    public boolean existOn(Coordonnee position) {
        return this.obstaclesPosition.contains(position);
    }
}
