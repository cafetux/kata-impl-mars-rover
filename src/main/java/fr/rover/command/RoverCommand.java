package fr.rover.command;

import fr.rover.Rover;

/**
 * Created by fmaury on 07/08/16.
 */
public interface RoverCommand {

    /**
     * apply the command to the rover
     * @return the new rover state
     */
    Rover execute();
}
