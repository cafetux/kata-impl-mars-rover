package fr.rover.command;

import fr.rover.Cardinality;
import fr.rover.Rover;
import org.junit.Test;

import java.util.Random;

import static fr.rover.Cardinality.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * Created by fmaury on 07/08/16.
 */
public class ForwardCommandTest {
    
    Random random = new Random();
    private Cardinality initialDirection = randomDirection();
    private int initialX = randomPosition();
    private int initialY = randomPosition();
    private RoverCommand command;
    private Rover newRoverState;

    @Test
    public void should_keep_the_same_direction_when_go_forward(){
        given_a_random_rover();
        when_rover_go_forward();
        then_is_on_the_same_direction();
    }

    @Test
    public void should_just_have_moved_distance_of_1_when_go_forward(){
        given_a_random_rover();
        when_rover_go_forward();
        then_have_just_move_a_distance_of(1);
    }

    @Test
    public void should_move_to_right_when_oriented_to_east(){
        given_a_rover(EAST);
        when_rover_go_forward();
        then_are_move_to(initialX + 1, initialY);
    }
    @Test
    public void should_move_to_left_when_oriented_to_west(){
        given_a_rover(WEST);
        when_rover_go_forward();
        then_are_move_to(initialX - 1, initialY);
    }
    @Test
    public void should_move_to_up_when_oriented_to_north(){
        given_a_rover(NORTH);
        when_rover_go_forward();
        then_are_move_to(initialX, initialY+1);
    }
    @Test
    public void should_move_to_down_when_oriented_to_south(){
        given_a_rover(SOUTH);
        when_rover_go_forward();
        then_are_move_to(initialX, initialY-1);
    }

    private void then_are_move_to(int expectedX, int expectedY) {
        assertThat(newRoverState.getX()).as("Bad value for X").isEqualTo(expectedX);
        assertThat(newRoverState.getY()).as("Bad value for Y").isEqualTo(expectedY);
    }

    private void then_have_just_move_a_distance_of(int expectedDistance) {
        assertThat(elapsedDistance()).isEqualTo(expectedDistance);
    }

    private int elapsedDistance() {
        return Math.abs(initialX-newRoverState.getX())+Math.abs(initialY-newRoverState.getY());
    }

    private void then_is_on_the_same_direction() {
        assertThat(newRoverState.getDirection()).as("direction cannot change when forward").isEqualTo(initialDirection);
    }

    private void when_rover_go_forward() {
        newRoverState = command.execute();
    }

    private void given_a_random_rover() {
        command = new ForwardCommand(new Rover(initialX, initialY,initialDirection));
    }

    private void given_a_rover(Cardinality direction) {
        command = new ForwardCommand(new Rover(initialX, initialY,direction));
    }

    private int randomPosition() {
        return random.nextInt(10);
    }

    private Cardinality randomDirection() {
        return Cardinality.values()[random.nextInt(4)];
    }

}