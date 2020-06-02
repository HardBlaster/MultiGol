package hu.unideb.multigol.gol.env;

import hu.unideb.multigol.gol.RuleSystem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public abstract class Environment {

    @Setter(AccessLevel.NONE)
    protected int width;
    @Setter(AccessLevel.NONE)
    protected int height;
    protected int currentGeneration;
    protected Cell[][] grid;
    protected RuleSystem ruleSystem;

    protected Environment(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getAlive() {
        return  (int) Arrays.stream(grid).flatMap(Arrays::stream).filter(Cell::isLive).count();
    }

    public void run(int generations) {
        for (int i = 0; i < generations; i++) {
            nextGen();
        }
    }

    public abstract void nextGen();

}
