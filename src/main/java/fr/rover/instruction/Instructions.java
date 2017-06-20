package fr.rover.instruction;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by fmaury on 13/08/16.
 */
public class Instructions {

    private List<Instruction> instructions;

    public Instructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public static Instructions from(Character[] instructions){
        return new Instructions(Arrays.stream(instructions).map(Instruction::from).collect(Collectors.toList()));
    }

    public Stream<Instruction> stream() {
        return StreamSupport.stream(Spliterators.spliterator(instructions, 0), false);
    }

}
