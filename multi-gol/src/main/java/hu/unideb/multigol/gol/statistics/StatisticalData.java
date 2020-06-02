package hu.unideb.multigol.gol.statistics;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticalData {

    @Setter(AccessLevel.NONE)
    private int cells;
    private int[] live;
    private int[][] neighbors;

    public StatisticalData(int cells, int maxGen, int neighbors) {
        this.cells = cells;
        this.live = new int[maxGen];
        this.neighbors = new int[maxGen][neighbors + 1];
    }

    public void setValues(int thGen, int live, int[] neighbors) {
        this.live[thGen-1] = live;
        this.neighbors[thGen-1] = neighbors;
    }
}
