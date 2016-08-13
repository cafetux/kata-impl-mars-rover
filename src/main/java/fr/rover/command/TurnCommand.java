package fr.rover.command;

import fr.rover.Cardinality;
import fr.rover.Rover;

/**
 * Created by fmaury on 13/08/16.
 */
public abstract class TurnCommand implements RoverCommand {

    protected final Rover rover;

    public TurnCommand(Rover rover){
        this.rover=rover;
    }
    protected Rover copyRoverFacing(Cardinality west) {
        return new Rover(rover.getX(), rover.getY(), west);
    }

}
