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
        switch (rover.getDirection()) {
            case SOUTH:
                return copyRoverFacing(WEST);
            case NORTH:
                return copyRoverFacing(EAST);
            case WEST:
                return copyRoverFacing(NORTH);
            case EAST:
                return copyRoverFacing(SOUTH);
            default:
                throw new IllegalArgumentException("invalid direction " + rover.getDirection());
        }
    }
}
