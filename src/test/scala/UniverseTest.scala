import com.googlecode.lanterna.terminal.{DefaultTerminalFactory, Terminal}
import org.scalatest.FunSuite

class UniverseTest extends FunSuite {


  test("test evolution") {

    val defaultTerminalFactory = new DefaultTerminalFactory()
    val terminal = defaultTerminalFactory.createTerminal()
    val visualizer = new LanternaVisualizer(terminal)
    val universe = new Universe(30, visualizer, new Cell(new Coordinate(5,5)), new Cell(new Coordinate(6,5)), new Cell(new Coordinate(7, 5)), new Cell(new Coordinate(7, 6)),new Cell(new Coordinate(6, 7)))
    /*val universe = new Universe(20, visualizer,
      new Cell(new Coordinate(1,3)),
      new Cell(new Coordinate(1,8)),
      new Cell(new Coordinate(2, 3)),
      new Cell(new Coordinate(2, 4)),
      new Cell(new Coordinate(2, 5)),
      new Cell(new Coordinate(2, 6)),
      new Cell(new Coordinate(2, 7)),
      new Cell(new Coordinate(2, 8)),
      new Cell(new Coordinate(3,3)),
      new Cell(new Coordinate(3,8)))
*/
    //val universe = new Universe(16, visualizer, new Cell(new Coordinate(4,4)), new Cell(new Coordinate(5,4)), new Cell(new Coordinate(6,4)))
/*
    val universe = new Universe(40, visualizer,
      new Cell(new Coordinate(4,4)),
      new Cell(new Coordinate(4,5)),
      new Cell(new Coordinate(2,5)),
      new Cell(new Coordinate(3,7)),
      new Cell(new Coordinate(4,8)),
      new Cell(new Coordinate(4,9)),
      new Cell(new Coordinate(4,10)))
*/

    var universeSnapshot = universe.init()
    universe.visualizeUniverse(universeSnapshot)


    for(i <- 0 to 100) {
      val nextSnapshot = universe.evolve(universeSnapshot)

      universe.visualizeUniverse(universeSnapshot)
      universeSnapshot = nextSnapshot
    }



  }

  /*test("triyng lanterna") {
    val defaultTerminalFactory = new DefaultTerminalFactory()
    try{
      val terminal = defaultTerminalFactory.createTerminal()
      terminal.putCharacter('O')
      terminal.putCharacter('P')
      terminal.putCharacter('O')
      terminal.putCharacter('L')
      terminal.putCharacter('P')
      terminal.putCharacter('O')
      terminal.flush()
      Thread.sleep(5000)
    }
  }*/




}
