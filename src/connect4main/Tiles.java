package connect4main;

/**
 * @author ajith
 *
 */
public class Tiles {

  private boolean open;
  private boolean occupied;
  private Position pos;

  /**
   * @author ajith
   *
   */
  public enum State {
    /**
     * Occupied by no-one.
     */
    EMPTY,
    /**
     * Occupied by blue.
     */
    BLUE,
    /**
     * Occupied by red.
     */
    RED,

  }

  private State tileState;

  /**
   * Constructor method to make tiles;
   * 
   * @param pos
   */
  public Tiles(Position pos) {
    this.open = true;
    this.occupied = false;
    this.setTileState(State.EMPTY);
    this.setPos(pos);
  }

  @Override
  public String toString() {
    if (getTileState().equals(State.EMPTY)) {
      return "_"; //$NON-NLS-1$
    } else if (getTileState().equals(State.RED)) {
      return "R"; //$NON-NLS-1$
    }
    return "B"; //$NON-NLS-1$
//    return String.valueOf(this.pos.getX());
//    if(this.open) {
//      return "T"; //$NON-NLS-1$
//    }
//    return "F"; //$NON-NLS-1$
  }

  /**
   * @return if tile is open
   */
  public boolean isOpen() {
    return this.open;
  }

  /**
   * @param open An open tile means it can be occupied
   */
  public void setOpen(boolean open) {
    this.open = open;
  }

  /**
   * @return get the tiles state.
   */
  public State getTileState() {
    return this.tileState;
  }

  /**
   * @param tileState determine whos occupying the tiles state
   */
  public void setTileState(State tileState) {
    this.tileState = tileState;
    if(!tileState.equals(State.EMPTY)) {
      this.open = false;
      this.occupied = true;
    }
  }

  /**
   * @return position of tile
   */
  public Position getPos() {
    return this.pos;
  }

  /**
   * @param pos
   */
  public void setPos(Position pos) {
    this.pos = pos;
  }

  /**
   * @return determines if tile is occupied
   */
  public boolean isOccupied() {
    return this.occupied;
  }

  /**
   * @param occupied
   */
  public void setOccupied(boolean occupied) {
    this.occupied = occupied;
  }

}
