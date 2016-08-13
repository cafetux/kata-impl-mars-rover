package fr.rover.command;

import fr.rover.Cardinality;
import fr.rover.Rover;
import org.junit.Test;

import static fr.rover.Cardinality.*;


/**
 * Created by fmaury on 07/08/16.
 */
public class BackCommandTest extends AbstractCommandTest {

    @Test
    public void should_keep_the_same_direction_when_go_back(){
        given_a_random_rover();
        when_rover_go_back();
        then_is_on_the_same_direction();
    }

    @Test
    public void should_just_have_moved_distance_of_1_when_go_back(){
        given_a_random_rover();
        when_rover_go_back();
        then_have_just_move_a_distance_of(1);
    }

    @Test
    public void should_move_to_left_when_oriented_to_east(){
        given_a_rover(EAST);
        when_rover_go_back();
        then_are_move_to(initialX - 1, initialY);
    }
    @Test
    public void should_move_to_right_when_oriented_to_west(){
        given_a_rover(WEST);
        when_rover_go_back();
        then_are_move_to(initialX + 1, initialY);
    }
    @Test
    public void should_move_to_down_when_oriented_to_north(){
        given_a_rover(NORTH);
        when_rover_go_back();
        then_are_move_to(initialX, initialY-1);
    }
    @Test
    public void should_move_to_up_when_oriented_to_south(){
        given_a_rover(SOUTH);
        when_rover_go_back();
        then_are_move_to(initialX, initialY+1);
    }

    private void when_rover_go_back() {
        newRoverState = command.execute();
    }

    RoverCommand getRoverCommand(Cardinality direction) {
        return new BackCommand(new Rover(initialX, initialY,direction));
    }

}