package fr.rover;

import fr.rover.command.RoverCommand;
import fr.rover.command.RoverCommandFactory;
import fr.rover.instruction.Instruction;
import fr.rover.instruction.Instructions;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Systeme de commande du Rover
 */
public class RoverCommandSystem {


    private Rover rover;
    private Function<Instruction, RoverCommand> TO_COMMAND = instruction -> RoverCommandFactory.get(instruction, rover);
    private Function<RoverCommand, Rover> EXECUTE = RoverCommand::execute;
    private Consumer<Rover> UPDATE_ROVER_STATE = this::fillRover;

    public RoverCommandSystem(Rover rover){
        this.rover=rover;
    }


    public void receive(Instructions instructions) {
        instructions.stream()
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
