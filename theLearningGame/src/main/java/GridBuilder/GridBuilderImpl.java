package GridBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.util.Pair;

public class GridBuilderImpl implements GridBuilder {

    private int rowSize;
    private int colSize;
    private int numberOfWalls;
    public Map< Pair<Integer, Integer>, Boolean> wallLoc = new HashMap< Pair<Integer,Integer>, Boolean>();
    public Map< Pair<Integer, Integer>, Boolean> prizeLoc = new HashMap< Pair<Integer, Integer>, Boolean>();
    private Random random = new Random();

    public GridBuilderImpl(int rowSize, int colSize, int numberOfWalls){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.numberOfWalls = numberOfWalls;
    }

    public void build(){
        try {
            buildPrizeLoc();
            buildWallLoc();
        }catch (NullPointerException e){
//            System.out.println("NullPointerException");
        }
    }

    private void buildWallLoc(){
        while(wallLoc.size() < numberOfWalls){
            int rowLoc = random.nextInt(rowSize) + 1;
            int colLoc = random.nextInt(colSize) + 1;
            Boolean checkPrize = prizeLoc.get(new Pair<Integer, Integer>(rowLoc, colLoc));
            Boolean checkWall = wallLoc.get(new Pair<Integer,Integer>(rowLoc,colLoc));
            if(checkPrize != null && checkPrize) continue;
            if(checkWall != null && checkWall) continue;
            wallLoc.put(new Pair<Integer, Integer>(rowLoc,colLoc), Boolean.TRUE);
        }
    }

    private void buildPrizeLoc(){
        int rowLoc = random.nextInt(rowSize) + 1;
        int colLoc = random.nextInt(colSize) + 1;
        prizeLoc.put(new Pair<Integer, Integer>(rowLoc, colLoc), Boolean.TRUE);
    }
}
