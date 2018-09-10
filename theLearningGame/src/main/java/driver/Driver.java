package driver;

import Player.Player;
import java.util.Scanner;

public class Driver {

  public int rowSize = 20;
  public int colSize = 20;
  public int numberOfWalls = 20;

  private int curRowLoc = 0;
  private int curColLoc = 0;

  private int gameStatus;
  public int moves = 0;

  public Driver(){

  }

  public void gameDriver(){
    Player player = new Player(rowSize, colSize, numberOfWalls);

    while(true){
      gameStatus = player.play(curRowLoc, curColLoc);
      if(gameStatus == 1 || gameStatus == 2) break;
      moves = moves + 1;
      playerMove();
    }

    if (gameStatus == 1) {
      System.out.println("You won in " + moves + " moves");
    }

    if(gameStatus == 2){
      System.out.println("You lose BUT you were in the game for " + moves + " moves");
    }
  }

  public void playerMove(){
    Scanner inp = new Scanner(System.in);
    System.out.println("CurLoc = " + curRowLoc + ", " + curColLoc + "\n");
    System.out.println("1 for UP, 2 for RIGHT");
    int move = inp.nextInt();
    if(move == 1) curRowLoc = curRowLoc + 1;
    else if(move == 2) curColLoc = curColLoc + 1;
    else{
      System.out.println("Wrong Move.......Input Again\n");
      playerMove();
    }
  }
}
