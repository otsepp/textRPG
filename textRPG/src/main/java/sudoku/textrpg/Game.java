
package sudoku.textrpg;

import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import sudoku.textrpg.characters.Player;

public class Game {
    
    private Player player;
    private List<Event> events;
    
    public Game() {
        player = new Player("Player");
        events = new ArrayList();
    }
    
    public void start() {
        
    }
    
}
