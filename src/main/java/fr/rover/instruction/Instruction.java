package fr.rover.instruction;

/**
 * Created by fmaury on 13/08/16.
 */
public class Instruction {

    private char instruction;

    public Instruction(char instruction) {
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
}
