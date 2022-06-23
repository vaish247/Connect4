package connect4main;

import connect4main.Tiles.State;

/**
 * @author ajith
 *
 */
public class Board {

  private Tiles[][] gameBoard;
  private final int BOARDSIZE;
  /**
   * 
   */
  public boolean blueTurn = true;
  private Tiles latestTile;
  /**
   * 
   */
  public Position latestTilePos;


  /**
   * Construct gameboard
   * 
   * @param size
   */
  public Board(int size) {
    this.BOARDSIZE = size;
    this.gameBoard = new Tiles[this.BOARDSIZE][this.BOARDSIZE];
    initialiseBoards();
    openTileInitial();
    
  }

  /**
   * @param pos
   */
  /**
   * Initializing all the open tiles
   */
  public void openTileInitial() {
    for (int i = 0; i < this.BOARDSIZE; i++) {
      for (int z = 0; z < this.BOARDSIZE; z++) {
        getGameBoard()[z][i].setOpen(false);
        if (z == this.BOARDSIZE - 1) {
          getGameBoard()[z][i].setOpen(true);
        }
      }
    }
  }

  /**
   * @param pos
   */
  public void placeTile(int pos) {
    if (pos < 1 || pos > 8) {
      System.out.println("ERROR"); //$NON-NLS-1$
    }
    checkColumn(0, pos);
  }
  /**
   * @param row
   * @param col
   */
  public void checkColumn(int row, int col) {
    Tiles a = getGameBoard()[row][col - 1];
    if (a.isOpen()) {
      Position atile = new Position(col - 1, row);
      setTile(atile);
      this.latestTilePos = atile;
    } else if (row == this.BOARDSIZE - 1) {
      System.out.println("None Available"); //$NON-NLS-1$
    } else {
      checkColumn(row + 1, col);
    }
  }

  /**
   * @param pos
   */
  public void setTile(Position pos) {
    if (this.blueTurn) {
      this.blueTurn = false;
      getGameBoard()[pos.getY()][pos.getX()].setTileState(State.BLUE);
      this.latestTile = getGameBoard()[pos.getY()][pos.getX()];
    } else {
      this.blueTurn = true;
      getGameBoard()[pos.getY()][pos.getX()].setTileState(State.RED);
      this.latestTile = getGameBoard()[pos.getY()][pos.getX()];
    }
    if (pos.getY() != 0) {
      getGameBoard()[pos.getY() - 1][pos.getX()].setOpen(true);
    }
  }

  /**
   * @return latestTiles
   */
  public Tiles latestTile() {
    return this.latestTile;
  }

  /**
   * initialising boards
   */
  public void initialiseBoards() {
    for (int i = 0; i < this.BOARDSIZE; i++) {
      for (int z = 0; z < this.BOARDSIZE; z++) {
        getGameBoard()[z][i] = new Tiles(new Position(i, z));
      }
    }
  }

  boolean theWin = false;
  
  
  /**
   * @param a
   * @param count
   * @param dir
   * @return the winner
   */
  public boolean checkWinner(Tiles a, int count, String dir) {
    Tiles.State tileState = a.getTileState();
    
    int right = a.getPos().getX() + 1;
    int left = a.getPos().getX() - 1;
    int top = a.getPos().getY() - 1;
    int down = a.getPos().getY() + 1;
    
    if(count == 4) {
      this.theWin = true;
      return this.theWin;

    }
    if (!a.isOccupied()) {
      return this.theWin;
    }
    
    if ((dir.equals("None") || dir.equals("R")) && right >= 0 && right < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[a.getPos().getY()][right];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "R"); //$NON-NLS-1$
      }
    }
    if ((dir.equals("None") || dir.equals("L"))&& left >= 0 && left < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[a.getPos().getY()][left];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "L"); //$NON-NLS-1$
      }
    }
    if ((dir.equals("None") || dir.equals("T")) && top >= 0 && top < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[top][a.getPos().getX()];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "T"); //$NON-NLS-1$
      }
    }
    if ((dir.equals("None") || dir.equals("D")) && down >= 0 && down < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[down][a.getPos().getX()];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "D"); //$NON-NLS-1$
      }
    }
    
    if ((dir.equals("None") || dir.equals("LD")) && left >= 0 && left < this.BOARDSIZE && down >= 0 && down < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[down][left];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "LD"); //$NON-NLS-1$
      }
    }
    
    if ((dir.equals("None") || dir.equals("RD")) && right >= 0 && right < this.BOARDSIZE && down >= 0 && down < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[down][right];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "RD"); //$NON-NLS-1$
      }
    }
    
    if ((dir.equals("None") || dir.equals("RT")) && top >= 0 && top < this.BOARDSIZE && right >= 0 && right < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[top][right];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "RT"); //$NON-NLS-1$
      }
      
    }
    if ((dir.equals("None") || dir.equals("RL")) &&left >= 0 && left < this.BOARDSIZE && top >= 0 && top < this.BOARDSIZE) { //$NON-NLS-1$ //$NON-NLS-2$
      Tiles next = getGameBoard()[top][left];
      if(next.getTileState().equals(tileState)) {
        checkWinner(next,count+1, "RL"); //$NON-NLS-1$
      }
    }    
    return this.theWin;
  }
  
  @Override
  public String toString() {
    StringBuilder stringer = new StringBuilder();
    for (int i = 0; i < this.BOARDSIZE; i++) {
      for (int z = 0; z < this.BOARDSIZE; z++) {
        if (z == 0) {
          stringer.append("|"); //$NON-NLS-1$
        }
        stringer.append(getGameBoard()[i][z].toString());
        stringer.append("|"); //$NON-NLS-1$
        if (z == this.BOARDSIZE - 1) {
          stringer.append("\n"); //$NON-NLS-1$
        }
      }
    }
    return stringer.toString();
  }

  /**
   * @return gameboard
   */
  public Tiles[][] getGameBoard() {
    return this.gameBoard;
  }

  /**
   * @param gameBoard set gameboard
   */
  public void setGameBoard(Tiles[][] gameBoard) {
    this.gameBoard = gameBoard;
  }

  /**
   * @return size of board
   */
  public int getBOARDSIZE() {
    return this.BOARDSIZE;
  }

  /**
   * @return whether it's blue turn
   */
  public boolean isBlueTurn() {
    return this.blueTurn;
  }

  /**
   * @param blueTurn
   */
  public void setBlueTurn(boolean blueTurn) {
    this.blueTurn = blueTurn;
  }
}
