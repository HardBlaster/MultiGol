package hu.unideb.multigol.gol.env.grid;

public class SquareHexagonalGrid extends HexagonalGrid {

    protected SquareHexagonalGrid(int width, int height) {
        super(width, height);
    }

    @Override
    protected int countNeighbors(int row, int column) {
        int count  = 0;

        for(int i = -1; i <= 1; i++) {
            for(int j = -2; j <= 2; j++) {
                if(!(i == 0 && j == 0) &&
                    row+i >= 0  && column+j >= 0 &&
                    row+i < height && column+j < width &&
                    grid[row+i][column+j].isLive()) {

                    count++;
                }
            }
        }

        if(row-2 >= 0 && grid[row-2][column].isLive()) {
            count++;
        }
        if(row+2 < grid.length && grid[row+2][column].isLive()) {
            count++;
        }

        return count;
    }
}
