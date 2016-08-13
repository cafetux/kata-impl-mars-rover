package fr.rover;

import fr.rover.command.*;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Arrays.stream;

/**
 * Systeme de commande du Rover
 */
public class RoverCommandSystem {


    private Rover rover;
    private Function<Character, RoverCommand> TO_COMMAND = instruction -> RoverCommandFactory.get(instruction, rover);
    private Function<RoverCommand, Rover> EXECUTE = RoverCommand::execute;
    private Consumer<Rover> UPDATE_ROVER_STATE = this::fillRover;

    public RoverCommandSystem(Rover rover){
        this.rover=rover;
    }


    public void receive(Character[] instructions) {
        stream(instructions)
                .map(TO_COMMAND)
                .map(EXECUTE)
                .forEach(UPDATE_ROVER_STATE);
    }

    private void fillRover(Rover newRover) {
        rover.setX(newRover.getX());
        rover.setY(newRover.getY());
        rover.setDirection(newRover.getDirection());
    }

}
