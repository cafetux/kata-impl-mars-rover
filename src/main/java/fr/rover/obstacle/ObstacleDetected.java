package fr.rover.obstacle;

import fr.rover.coordonnee.Coordonnee;

/**
 * Created by fmaury on 15/08/16.
 */
public class ObstacleDetected extends RuntimeException {
    private Coordonnee encounteredObstacle;

    public ObstacleDetected(Coordonnee encounteredObstacle) {
        super("encountered obstacle on "+encounteredObstacle);
        this.encounteredObstacle = encounteredObstacle;
    }

    public Coordonnee getPosition() {
        return encounteredObstacle;
    }
}
