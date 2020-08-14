package hu.unideb.multigol.gol.env.grid;

import java.util.Random;

import hu.unideb.multigol.gol.env.Cell;

public abstract class HexagonalGrid extends Environment {

    protected static class Coordinate {
        int row;
        int column;
    }

    protected HexagonalGrid(int width, int height) {
        super(width, height);
        grid = new Cell[height][width * 2];
    }

    @Override
    public void generate(int AR) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Coordinate coordinate = realCoordinates(i, j);
                Random random = new Random();
                grid[coordinate.row][coordinate.column] = new Cell();

                if(random.nextInt(100)+1 <= AR) {
                    grid[coordinate.row][coordinate.column].live();
                } else {
                    grid[coordinate.row][coordinate.column].kill();
                }
            }
        }
    }

    @Override
    public void nextGen() {
        refreshNeighborhoodMatrix();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Coordinate coordinate = realCoordinates(i, j);

                switch (ruleSystem.nextState(neighborhoodMatrix[i][j])) {
                    case 'B':
                        grid[coordinate.row][coordinate.column].live();
                        break;
                    case 'D':
                        grid[coordinate.row][coordinate.column].kill();
                        break;
                }
            }
        }
    }

    protected Coordinate realCoordinates(int row, int column) {
        Coordinate coordinate = new Coordinate();

        coordinate.row = row;
        coordinate.column = row%2 == 0 ? column*2 : column*2+1;

        return coordinate;
    }

    private void refreshNeighborhoodMatrix() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {

                Coordinate coordinate = realCoordinates(i, j);
                neighborhoodMatrix[coordinate.row][coordinate.column] = countNeighbors(i, j);
            }
        }
    }

    protected abstract int countNeighbors(int row, int column);
}
