package fr.rover;

import fr.rover.instruction.Instructions;
import org.junit.Test;

import static fr.rover.Cardinality.NORTH;
import static fr.rover.Cardinality.SOUTH;
import static fr.rover.Cardinality.WEST;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * tests du systéme rover
 */
public class RoverTest {


    private int initialX;
    private int initialY;
    private Rover roverUnderTest;

    private RoverCommandSystem commandSystem;

    @Test
    public void should_go_forward(){
        given_a_rover_on_position(5, 5);
        and_facing_to(SOUTH);

        when_rover_receive_instruction('f');

        then_the_rover_is_on_position(5,4);
        and_facing(SOUTH);
    }

    @Test
    public void should_go_back(){
        given_a_rover_on_position(3, 5);
        and_facing_to(NORTH);

        when_rover_receive_instruction('b');

        then_the_rover_is_on_position(3,4);
        and_facing(NORTH);
    }

    @Test
    public void should_can_turn_left(){
        given_a_rover_on_position(5, 5);
        and_facing_to(WEST);

        when_rover_receive_instruction('l');

        then_the_rover_is_on_position(5,5);
        and_facing(SOUTH);
    }

    @Test
    public void should_can_turn_right(){
        given_a_rover_on_position(5, 5);
        and_facing_to(SOUTH);

        when_rover_receive_instruction('r');

        then_the_rover_is_on_position(5,5);
        and_facing(WEST);
    }

    @Test
    public void should_send_multiple_commands(){
        given_a_rover_on_position(5, 5);
        and_facing_to(NORTH);

        when_rover_receive_orders('r','f','f','l','b','l','l','f');

        then_the_rover_is_on_position(7,3);
        and_facing(SOUTH);
    }

    private void and_facing(Cardinality facingTo) {
        assertThat(roverUnderTest.getDirection()).as("invalid rover direction").isEqualTo(facingTo);
    }

    private void then_the_rover_is_on_position(int expectingX, int expectingY) {
        assertThat(roverUnderTest.getX()).as("invalid X position").isEqualTo(expectingX);
        assertThat(roverUnderTest.getY()).as("invalid Y position").isEqualTo(expectingY);
    }

    private void when_rover_receive_instruction(char instruction) {
        commandSystem.receive(Instructions.from(new Character[]{instruction}));
    }
    private void when_rover_receive_orders(Character... commands) {
        commandSystem.receive(Instructions.from(commands));
    }

    private void and_facing_to(Cardinality direction) {
        roverUnderTest = new Rover(initialX,initialY, direction);
        commandSystem = new RoverCommandSystem(roverUnderTest);
    }

    private void given_a_rover_on_position(int x, int y) {
        this.initialX=x;
        this.initialY=y;
    }


}
