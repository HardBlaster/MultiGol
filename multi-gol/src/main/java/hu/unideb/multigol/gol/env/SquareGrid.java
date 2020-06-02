package hu.unideb.multigol.gol.env;

public class SquareGrid extends Environment {

    protected SquareGrid(int width, int height) {
        super(width, height);
        grid = new Cell[height][width];
    }

    @Override
    public void nextGen() {

    }
}
