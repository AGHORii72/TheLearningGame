package GridBuilder;

import javafx.util.Pair;

public class Grid {

    private final int rowSize, colSize;
    private final int numberOfWalls;
    private GridBuilderImpl gridBuilder;

    public Grid(int rowSize, int colSize, int numberOfWalls){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.numberOfWalls = numberOfWalls;
    }

    public void build(){
        gridBuilder = new GridBuilderImpl(rowSize, colSize, numberOfWalls);
        gridBuilder.build();
    }

    public boolean checkForWall(int curRowLoc, int curColLoc){
        Boolean check = gridBuilder.wallLoc.get(new Pair<Integer, Integer>(curRowLoc, curColLoc));
        if(check != null && check) return true;
        if(curRowLoc > rowSize || curColLoc > colSize) return true;
        return false;
    }

    public boolean checkForPrize(int curRowLoc, int curColLoc){
        Boolean check = gridBuilder.prizeLoc.get(new Pair<Integer, Integer>(curRowLoc, curColLoc));
        if(check != null && check) return true;
        return false;
    }
}
