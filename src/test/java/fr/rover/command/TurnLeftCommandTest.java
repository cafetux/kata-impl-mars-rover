package fr.rover.command;

import fr.rover.Cardinality;
import fr.rover.Rover;
import fr.rover.command.turn.TurnLeftCommand;
import org.junit.Test;

import static fr.rover.Cardinality.*;


/**
 * Created by fmaury on 07/08/16.
 */
public class TurnLeftCommandTest extends AbstractCommandTest {

    @Test
    public void should_change_direction_when_turn_leff(){
        given_a_random_rover();
        when_rover_turn_left();
        then_is_on_other_direction();
    }

    @Test
    public void should_be_at_the_same_position_when_turn(){
        given_a_random_rover();
        when_rover_turn_left();
        then_is_at_the_same_position();
    }

    @Test
    public void should_facing_west_after_turn_left_when_oriented_to_north(){
        given_a_rover(NORTH);
        when_rover_turn_left();
        then_facing_to(WEST);
    }



    @Test
    public void should_facing_south_after_turn_left_when_oriented_to_west(){
        given_a_rover(WEST);
        when_rover_turn_left();
        then_facing_to(SOUTH);
    }


    @Test
    public void should_facing_east_after_turn_left_when_oriented_to_south(){
        given_a_rover(SOUTH);
        when_rover_turn_left();
        then_facing_to(EAST);
    }


    @Test
    public void should_facing_north_after_turn_left_when_oriented_to_east(){
        given_a_rover(EAST);
        when_rover_turn_left();
        then_facing_to(NORTH);
    }


    private void when_rover_turn_left() {
        newRoverState = command.execute();
    }

    RoverCommand getRoverCommand(Cardinality direction) {
        return new TurnLeftCommand(new Rover(initialX, initialY,direction));
    }

}