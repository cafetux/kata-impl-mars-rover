package fr.rover.instruction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fmaury on 13/08/16.
 */
public class Instruction {

    private static final Map<Character,Instruction> singletons=new HashMap<>();
    private char instruction;

    private Instruction(char instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        return instruction == that.instruction;

    }

    @Override
    public int hashCode() {
        return (int) instruction;
    }

    public static Instruction from(char instruction) {
        if(!singletons.containsKey(instruction)){
            singletons.put(instruction,new Instruction(instruction));
        }
        return singletons.get(instruction);
    }
}
