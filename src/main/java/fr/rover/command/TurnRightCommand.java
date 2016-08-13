package fr.rover.command;

import fr.rover.Rover;

import static fr.rover.Cardinality.*;

/**
 * Created by fmaury on 13/08/16.
 */
public class TurnRightCommand extends TurnCommand {

    public TurnRightCommand(Rover rover){
        super(rover);
    }

    public Rover execute() {
        if (rover.getDirection() == SOUTH) {
            return copyRoverFacing(WEST);
        }
        if (rover.getDirection() == NORTH) {
            return copyRoverFacing(EAST);
        }
        if (rover.getDirection() == WEST) {
            return copyRoverFacing(NORTH);
        }
        if (rover.getDirection() == EAST) {
            return copyRoverFacing(SOUTH);
        }
        return rover;
    }


}
