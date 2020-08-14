package hu.unideb.multigol.gol.env;

import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RuleSystem {

    private int[] bornIf;
    private int[] stableIf;
    private int[] deadIf;

    public char nextState(int neighbors) {
        if(arrayContains(bornIf, neighbors)) {
            return 'B';
        } else if (arrayContains(deadIf, neighbors)) {
            return 'D';
        } else {
            return 'S';
        }
    }

    private boolean arrayContains(int[] array, int number) {
        return IntStream.of(array).anyMatch(e -> e == number);
    }
}
