package fr.rover.command;

import fr.rover.Rover;

import static fr.rover.Cardinality.*;

/**
 * Created by fmaury on 13/08/16.
 */
public class TurnRightCommand implements RoverCommand {

    private final Rover rover;

    public TurnRightCommand(Rover rover){
        this.rover=rover;
    }

    public Rover execute() {
        if (rover.getDirection() == SOUTH) {
            return new Rover(rover.getX(), rover.getY(), WEST);
        }
        if (rover.getDirection() == NORTH) {
            return new Rover(rover.getX(), rover.getY(), EAST);
        }
        if (rover.getDirection() == WEST) {
            return new Rover(rover.getX(), rover.getY(), NORTH);
        }
        if (rover.getDirection() == EAST) {
            return new Rover(rover.getX(), rover.getY(), SOUTH);
        }
        return rover;
    }

    }
