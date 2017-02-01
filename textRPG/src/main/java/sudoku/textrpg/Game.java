
package sudoku.textrpg;

import java.util.ArrayList;
import java.util.List;
import sudoku.textrpg.characters.Player;
import sudoku.textrpg.game_events.GameEvent;
import sudoku.textrpg.game_events.StraightPathEvent;

public class Game {
    
    private Player player;
    private List<GameEvent> events;
    
    public Game() {
        player = new Player("Player");
        events = new ArrayList();
    }
    
    public void start() {
        System.out.println("Welcome...\n");
        createEvents();
        
        
        for (GameEvent e : events) {
            e.initiateEvent();
        }
    }
    
    public void createEvents() {
        this.events.add(new StraightPathEvent());
    }
    
}
