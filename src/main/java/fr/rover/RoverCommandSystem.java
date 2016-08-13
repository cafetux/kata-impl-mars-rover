package fr.rover;

import fr.rover.command.BackCommand;
import fr.rover.command.ForwardCommand;
import fr.rover.command.TurnLeftCommand;

/**
 * Systeme de commande du Rover
 */
public class RoverCommandSystem {


    private final Rover rover;

    public RoverCommandSystem(Rover rover){
        this.rover=rover;
    }


    public void receive(Character[] commands) {
        Rover newRover = rover;
        if (commands[0] == 'f') {
            newRover = new ForwardCommand(rover).execute();
        }
        if (commands[0] == 'b') {
            newRover = new BackCommand(rover).execute();
        }
        if (commands[0] == 'l') {
            newRover = new TurnLeftCommand(rover).execute();
        }
        rover.setX(newRover.getX());
        rover.setY(newRover.getY());
        rover.setDirection(newRover.getDirection());
    }

}
