package hu.unideb.multigol.gol.env;

public class Cell {

    public static final byte INVALID = -1;
    public static final byte ALIVE = 1;
    public static final byte DEAD = 0;

    private byte status;

    public Cell() {
        this.status = INVALID;
    }

    public Cell(boolean live) {
        this.status = live ? ALIVE : DEAD;
    }

    public void kill() {
        this.status = DEAD;
    }

    public void live() {
        this.status = ALIVE;
    }

    public void invalidate() {
        this.status = INVALID;
    }

    public boolean isLive() {
        return this.status == ALIVE;
    }

    public boolean isDead() {
        return this.status == DEAD;
    }

    public boolean isValid() {
        return this.status != INVALID;
    }

    @Override
    public String toString() {
        return "Cell " + "(" + status + ")";
    }

}
