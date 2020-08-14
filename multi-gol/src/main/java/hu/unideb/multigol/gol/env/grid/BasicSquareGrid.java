package hu.unideb.multigol.gol.env.grid;

public class BasicSquareGrid extends SquareGrid {

    protected BasicSquareGrid(int width, int height) {
        super(width, height);
    }

    protected int countNeighbors(int row, int column) {
        int count = 0;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(!(i == 0 && j == 0) &&
                   row+i >= 0  && column+j >= 0 &&
                   row+i < height && column+j < width &&
                   grid[row+i][column+j].isLive()) {
                    count++;
                }
            }
        }

        return count;
    }

}
