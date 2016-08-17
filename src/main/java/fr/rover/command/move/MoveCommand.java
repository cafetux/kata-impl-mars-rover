package fr.rover.command.move;

import fr.rover.Map;
import fr.rover.obstacle.ObstacleDetected;
import fr.rover.Rover;
import fr.rover.command.RoverCommand;

/**
 * Created by fmaury on 07/08/16.
 */
public abstract class MoveCommand implements RoverCommand {

    protected final Rover rover;
    private final Map map;

    public MoveCommand(Rover rover, Map map){
        this.rover=rover;
        this.map=map;
    }

    public Rover execute() {
        Rover newRoverState = getNewRoverState();
        newRoverState=adjustOnContinuousMap(newRoverState);
        detectObstacle(newRoverState);
        return newRoverState;
    }

    private Rover adjustOnContinuousMap(Rover newRoverState) {
        newRoverState.setPosition(map.getRealposition(newRoverState.getPosition()));
        return newRoverState;
    }

    private void detectObstacle(Rover newRoverState) {
        if (!map.isAvailable(newRoverState.getPosition())) {
            throw new ObstacleDetected(newRoverState.getPosition());
        }
    }

    abstract protected Rover getNewRoverState();
}
