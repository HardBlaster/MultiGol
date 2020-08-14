package hu.unideb.multigol.gol.env.grid;

import java.util.Arrays;
import java.util.Random;

import hu.unideb.multigol.gol.env.Cell;

public abstract class SquareGrid extends Environment {

    protected SquareGrid(int width, int height) {
        super(width, height);
        grid = new Cell[height][width];
    }

    @Override
    public void generate(int AR) {
        Random random = new Random();
        Arrays.stream(grid)
            .forEach(row -> Arrays.stream(row)
                .forEach(cell -> {
                    cell = new Cell();

                    if (random.nextInt(100)+1 <= AR) {
                        cell.live();
                    } else {
                        cell.kill();
                    }
                }));
    }

    @Override
    public void nextGen() {
        refreshNeighborhoodMatrix();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                switch (ruleSystem.nextState(neighborhoodMatrix[i][j])) {
                    case 'B':
                        grid[i][j].live();
                        break;
                    case 'D':
                        grid[i][j].kill();
                        break;
                }
            }
        }
    }

    private void refreshNeighborhoodMatrix() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                neighborhoodMatrix[i][j] = countNeighbors(i, j);
            }
        }
    }

    protected abstract int countNeighbors(int row, int column);
}
