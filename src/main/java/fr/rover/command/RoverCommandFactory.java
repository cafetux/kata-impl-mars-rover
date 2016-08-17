package fr.rover.command;

import fr.rover.Map;
import fr.rover.command.move.BackCommand;
import fr.rover.command.move.ForwardCommand;
import fr.rover.command.turn.TurnLeftCommand;
import fr.rover.command.turn.TurnRightCommand;
import fr.rover.instruction.Instruction;
import fr.rover.Rover;

/**
 * Created by fmaury on 13/08/16.
 */
public class RoverCommandFactory {


    public static final Instruction FORWARD = new Instruction('f');
    public static final Instruction BACK = new Instruction('b');
    public static final Instruction TURN_LEFT = new Instruction('l');
    public static final Instruction TURN_RIGHT = new Instruction('r');
    private static Map map;

    public static RoverCommand get(Instruction instruction,Rover rover){
        if(map==null){
            throw new IllegalStateException("Map must be initialized");
        }
        if (FORWARD.equals(instruction)) {
            return new ForwardCommand(rover,map);
        }
        if (BACK.equals(instruction)) {
            return new BackCommand(rover,map);
        }
        if (TURN_LEFT.equals(instruction)) {
            return new TurnLeftCommand(rover);
        }
        if (TURN_RIGHT.equals(instruction)) {
            return new TurnRightCommand(rover);
        }
        throw new IllegalArgumentException("no command found for instruction "+instruction);
    }

    public static void setMap(Map map){
        RoverCommandFactory.map = map;
    }
    
}
