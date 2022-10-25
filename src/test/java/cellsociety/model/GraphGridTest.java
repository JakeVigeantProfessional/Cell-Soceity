package cellsociety.model;
import cellsociety.model.cells.Cell;
import cellsociety.model.cells.GameOfLifeCell;
import cellsociety.model.grids.GraphGrid;
import java.util.HashMap;

import cellsociety.view.GridWrapper;
import java.util.Properties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphGridTest {
  GridWrapper gridParsing = new GridWrapper();


  @Test
  void testBasicObject(){
    constructTestArrayList(4,4);
    Properties properties = new Properties();
    properties.put("Type", "GameOfLife");
    GraphGrid gameOfLifeGrid = new GraphGrid(gridParsing, properties);
    HashMap<Integer, Cell> testCells = new HashMap<>();
    for(int i = 0; i < 16; i++){

      testCells.put(i, new GameOfLifeCell(1,i));
    }
    assertEquals(testCells.get(1).getCurrentState(),gameOfLifeGrid.getCells().get(16).getCurrentState());
    assertEquals(testCells.size(), gameOfLifeGrid.getCells().size());

  }
  @Test
  void testBounds(){
    constructTestArrayList(12,12);
    assertEquals(true , GraphGrid.isInBounds(1,1,gridParsing));

  }
  public void constructTestArrayList(int rows, int cols){
    for(int i = 0; i < rows; i++){
      gridParsing.addRow();
      for(int j = 0; j < cols; j++){
        if(i == 0 && j ==0)
          gridParsing.addValueToRow(i, 0);
        else
          gridParsing.addValueToRow(i, 1);
      }
    }
  }
}
