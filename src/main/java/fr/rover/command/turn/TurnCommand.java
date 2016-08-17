package fr.rover.command.turn;

import fr.rover.Cardinality;
import fr.rover.Rover;
import fr.rover.command.RoverCommand;

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
