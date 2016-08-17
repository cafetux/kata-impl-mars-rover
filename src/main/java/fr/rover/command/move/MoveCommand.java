package fr.rover.command.move;

import fr.rover.Map;
import fr.rover.ObstacleDetected;
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
        if(map.isAvailable(newRoverState.getPosition())){
            return newRoverState;
        }else{
            throw new ObstacleDetected(newRoverState.getPosition());
        }

    }

    abstract protected Rover getNewRoverState();
}
