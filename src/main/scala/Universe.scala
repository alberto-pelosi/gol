

class Universe(length: Int, visualizer: Visualizer, initialState: Cell*) {




  def visualizeUniverse(universeSnapshot: Array[Array[Cell]]): Unit = {
   visualizer.visualize(universeSnapshot)
    Thread.sleep(1000)
  }



  def init(): Array[Array[Cell]] = {
    val universeSnapshot = initialize(length, initialState)
    universeSnapshot
  }

  def evolve(universe: Array[Array[Cell]]): Array[Array[Cell]] = {
    val universeSnapshot = universeEvolution(universe)
    universeSnapshot
  }



  def universeEvolution(universe: Array[Array[Cell]]) : Array[Array[Cell]] = {
    val nextUniverse = Array.ofDim[Cell](length,length)
    for(i <- 0 to universe.length-1) {
      for(j <- 0 to universe(i).length-1) {
        nextUniverse(i)(j) = computeNewCell(universe, universe(i)(j))
      }
    }
    nextUniverse
  }


  def computeNewCell(universe: Array[Array[Cell]], cell: Cell): Cell = {
    val numberOfAliveNeighbors = computeNumberOfAliveNeighbors(universe, cell)
    if(cell.cellType.equals(CellType.ALIVE)) {
      if (numberOfAliveNeighbors.equals(2) || numberOfAliveNeighbors.equals(3)) return new Cell(cell.coordinate, CellType.ALIVE)
      else return new Cell(cell.coordinate, CellType.DEATH)

    } else {
      if(numberOfAliveNeighbors.equals(3)) return new Cell(cell.coordinate, CellType.ALIVE)
      else return new Cell(cell.coordinate, CellType.DEATH)

    }

  }

  def computeNumberOfAliveNeighbors(universe: Array[Array[Cell]], cell: Cell) : Int = {
    var numberOfAliveNeighbors = 0;
    for(i <- cell.coordinate.row -1 to cell.coordinate.row+1) {
      for(j <- cell.coordinate.column -1 to cell.coordinate.column+1){
        if(validateCoordinate(new Coordinate(i, j)) && !universe(i)(j).coordinate.equals(cell.coordinate)) {
          if(universe(i)(j).cellType.equals(CellType.ALIVE)) {
            numberOfAliveNeighbors += 1
          }
        }
      }
    }
    numberOfAliveNeighbors
  }



  private def initialize(lenght: Int, initialState: Seq[Cell]): Array[Array[Cell]] = {

    val initialUniverse = Array.ofDim[Cell](length, lenght)

    for(i <- 0 to lenght-1) {
      for(j <- 0 to length-1){
        initialUniverse(i)(j) = new Cell(new Coordinate(i, j), CellType.DEATH)
      }
    }

    initialState.foreach(cell => {
      initialUniverse(cell.coordinate.row)(cell.coordinate.column) = cell

    })

    initialUniverse

  }


  private def validateCoordinate(coordinate: Coordinate) : Boolean = {
    if(coordinate.row >= 0 && coordinate.row < length
      && coordinate.column >= 0 && coordinate.column < length)
      true
    else false
  }



}

object Universe{

  val MIN_NUMBER_TO_LIVE = 2
  val MAX_NUMBER_TO_LIVE = 3


}
