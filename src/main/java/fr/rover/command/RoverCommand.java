package fr.rover.command;

import fr.rover.Rover;

/**
 * Created by fmaury on 07/08/16.
 */
public interface RoverCommand {

    /**
     * execute the command
     * @return the new rover state
     */
    Rover execute();
}
