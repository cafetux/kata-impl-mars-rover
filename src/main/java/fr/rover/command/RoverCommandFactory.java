package fr.rover.command;

import fr.rover.Rover;

/**
 * Created by fmaury on 13/08/16.
 */
public class RoverCommandFactory {
    

    public static RoverCommand get(char instruction,Rover rover){
        if (instruction == 'f') {
            return new ForwardCommand(rover);
        }
        if (instruction == 'b') {
            return new BackCommand(rover);
        }
        if (instruction == 'l') {
            return new TurnLeftCommand(rover);
        }
        if (instruction == 'r') {
            return new TurnRightCommand(rover);
        }
        throw new IllegalArgumentException("no command found for instruction "+instruction);
    }
    
}
