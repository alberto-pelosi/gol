import com.googlecode.lanterna.terminal.Terminal

class LanternaVisualizer(val terminal: Terminal) extends Visualizer {



  override def visualize(universeSnapshot: Array[Array[Cell]]): Unit = {
    terminal.setCursorPosition(0,0)
    for(i <- 0 to universeSnapshot.length-1) {
      terminal.putCharacter('|')
      for(j <- 0 to universeSnapshot(i).length-1){
        terminal.putCharacter(universeSnapshot(i)(j).toString.charAt(0))
        terminal.putCharacter('|')
      }
      terminal.putCharacter('\n')

    }
    terminal.flush()



  }
}
