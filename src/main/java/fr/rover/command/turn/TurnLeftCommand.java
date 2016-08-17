package fr.rover.command.turn;

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
        switch (rover.getDirection()) {
            case SOUTH:
                return copyRoverFacing(EAST);
            case NORTH:
                return copyRoverFacing(WEST);
            case WEST:
                return copyRoverFacing(SOUTH);
            case EAST:
                return copyRoverFacing(NORTH);
            default:
                throw new IllegalArgumentException("invalid direction "+rover.getDirection());
        }
    }
}
