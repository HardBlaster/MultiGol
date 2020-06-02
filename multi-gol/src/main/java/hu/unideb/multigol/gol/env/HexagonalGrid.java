package hu.unideb.multigol.gol.env;

public class HexagonalGrid extends Environment {

    protected HexagonalGrid(int width, int height) {
        super(width, height);
        grid = new Cell[height][width * 2];
    }

    @Override
    public void nextGen() {

    }
}
