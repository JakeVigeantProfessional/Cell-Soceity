package cellsociety.model.grids;

import cellsociety.model.cells.Cell;
import cellsociety.view.GridWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SwappedCellsGraphGrid extends GraphGrid{

  /**
   * Constructor for GraphGrid class
   *
   * @param gridParsing is the layout of the grid
   * @param properties
   */
  public SwappedCellsGraphGrid(GridWrapper gridParsing,
      Properties properties) {
    super(gridParsing, properties);
  }
  public Cell findCelltoSwap(Cell startingCell, List<Cell> locations, int targetState) {
    ArrayList<Cell> potentialLocations = new ArrayList();
    for (Cell potentialCell : locations) {
      if (potentialCell.getCurrentState() == targetState) {
        potentialLocations.add(potentialCell);
      }
      //No cells found that match the state we need to swap into
      if(potentialLocations.size() == 0){
        return startingCell;
      }
    }
    //Of the cells with the correct ending state, select one at random
    return potentialLocations.get(getRandomIndex(potentialLocations.size()));
  }
  public int getRandomIndex(int listLength){
    return (int) Math.floor(Math.random()*(listLength));
  }

}