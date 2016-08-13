package fr.rover.command;

import fr.rover.Cardinality;
import fr.rover.Rover;

/**
 * Created by fmaury on 07/08/16.
 */
public class BackCommand implements RoverCommand {

    private final Rover rover;

    public BackCommand(Rover rover){
        this.rover=rover;
    }

    public Rover execute() {
        if(rover.getDirection()== Cardinality.SOUTH){
            return new Rover(rover.getX(),rover.getY()+1,rover.getDirection());
        }

        if(rover.getDirection()== Cardinality.NORTH){
            return new Rover(rover.getX(),rover.getY()-1,rover.getDirection());
        }

        if(rover.getDirection()== Cardinality.EAST){
            return new Rover(rover.getX()-1,rover.getY(),rover.getDirection());
        }

        if(rover.getDirection()== Cardinality.WEST){
            return new Rover(rover.getX()+1,rover.getY(),rover.getDirection());
        }
        throw new IllegalArgumentException("invalid direction "+rover.getDirection());

    }
}
