package hu.unideb.multigol.gol.env.grid;

import hu.unideb.multigol.gol.env.Cell;
import hu.unideb.multigol.gol.env.RuleSystem;
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
    protected int[][] neighborhoodMatrix;
    protected RuleSystem ruleSystem;

    protected Environment(int width, int height) {
        this.width = width;
        this.height = height;
        this.neighborhoodMatrix = new int[height][width];
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

    public abstract void generate(int AR);

}
