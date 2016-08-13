package fr.rover.command;

import fr.rover.Rover;

import static fr.rover.Cardinality.*;

/**
 * Created by fmaury on 13/08/16.
 */
public class TurnLeftCommand extends TurnCommand {

    public TurnLeftCommand(Rover rover){
        super(rover);
    }

    public Rover execute() {
        if (rover.getDirection() == SOUTH) {
            return copyRoverFacing(EAST);
        }
        if (rover.getDirection() == NORTH) {
            return copyRoverFacing(WEST);
        }
        if (rover.getDirection() == WEST) {
            return copyRoverFacing(SOUTH);
        }
        if (rover.getDirection() == EAST) {
            return copyRoverFacing(NORTH);
        }
        return rover;
    }

    }
