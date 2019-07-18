case class Cell(coordinate: Coordinate, cellType: CellType.Value = CellType.ALIVE) {



  override def toString: String = {
    if(cellType.equals(CellType.ALIVE)) "X"
    else " "
  }

}


