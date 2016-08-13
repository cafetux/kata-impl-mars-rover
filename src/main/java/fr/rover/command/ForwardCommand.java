package fr.rover.command;

import fr.rover.Rover;

/**
 * Created by fmaury on 07/08/16.
 */
public class ForwardCommand implements RoverCommand {

    private final Rover rover;

    public ForwardCommand(Rover rover){
        this.rover=rover;
    }

    public Rover execute() {
        switch (rover.getDirection()) {
            case SOUTH:
                return new Rover(rover.getX(), rover.getY() - 1, rover.getDirection());
            case NORTH:
                return new Rover(rover.getX(), rover.getY() + 1, rover.getDirection());
            case EAST:
                return new Rover(rover.getX() + 1, rover.getY(), rover.getDirection());
            case WEST:
                return new Rover(rover.getX() - 1, rover.getY(), rover.getDirection());
            default:
                throw new IllegalArgumentException("invalid direction "+rover.getDirection());
        }
    }
}
