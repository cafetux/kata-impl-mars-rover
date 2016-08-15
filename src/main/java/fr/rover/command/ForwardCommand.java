package fr.rover.command;

import fr.rover.Map;
import fr.rover.ObstacleDetected;
import fr.rover.Rover;

/**
 * Created by fmaury on 07/08/16.
 */
public class ForwardCommand implements RoverCommand {

    private final Rover rover;
    private final Map map;

    public ForwardCommand(Rover rover, Map map){
        this.rover=rover;
        this.map=map;
    }

    public Rover execute() {
        Rover newRoverState = null;
        switch (rover.getDirection()) {
            case SOUTH:
                newRoverState= new Rover(rover.getX(), rover.getY() - 1, rover.getDirection());
                break;
            case NORTH:
                newRoverState= new Rover(rover.getX(), rover.getY() + 1, rover.getDirection());
                break;
            case EAST:
                newRoverState= new Rover(rover.getX() + 1, rover.getY(), rover.getDirection());
                break;
            case WEST:
                newRoverState= new Rover(rover.getX() - 1, rover.getY(), rover.getDirection());
                break;
            default:
                throw new IllegalArgumentException("invalid direction "+rover.getDirection());
        }
        if(map.isAvailable(newRoverState.getPosition())){
            return newRoverState;
        }else{
            throw new ObstacleDetected(newRoverState.getPosition());
        }

    }
}
