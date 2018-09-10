package Player;

import GridBuilder.Grid;

public class Player {

  private int curRowLoc = 0;
  private int curColLoc = 0;
  private Grid grid;

  public Player(int rowSize, int colSize, int numberOfWalls){
    grid = new Grid(rowSize, colSize, numberOfWalls);
    makeGame();
  }

  public void makeGame(){
    grid.build();
  }

  public Integer play(int curRowLoc, int curColLoc){
    try {
      if (grid.checkForPrize(curRowLoc, curColLoc)) return 1;
      if (grid.checkForWall(curRowLoc, curColLoc)) return 2;
    }catch (NullPointerException e){
//      System.out.println("NullPointerException");
    }
    return 0;
  }

}
