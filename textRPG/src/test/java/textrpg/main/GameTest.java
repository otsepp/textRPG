
package textrpg.main;

import java.util.ArrayDeque;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.event.GameEvent;
import textrpg.event.straightpath.StraightPathEvent;

public class GameTest {
    private Game game;
    
    public GameTest() {
    }
    
    @Before
    public void setUp() {
        this.game = new Game();
    }
    
    
    @Test
    public void constructorSetGameInDefaultState() {
        assertEquals(true, this.game.getPlayer() != null);
        assertEquals(false, this.game.getEvents().isEmpty());
        assertEquals(true, this.game.getCurrentEvent().equals(this.game.getEvents().peek()));
        
        String firstMessage = this.game.getLatestMessages().get(0);
        assertEquals(true, firstMessage.equals(this.game.getCurrentEvent().getStartMessage()));
    }

    @Test
    public void executeCommandDeniesWrongCommandId() {
        assertEquals(true, this.game.executeCommand(this.game.getEvents().size()) == null );
        assertEquals(true, this.game.executeCommand(-1) == null);
    }
    
    @Test
    public void executeCommandWorks() {
        createTestEvents();
        GameStatus ret = this.game.executeCommand(0);
        assertEquals(GameStatus.GAME_CONTINUE, ret);
        ret = this.game.executeCommand(0);
        assertEquals(GameStatus.GAME_END, ret);
    }
    
    @Test
     public void settingUpNextEventWorksWhenManyEvents() {
          createTestEvents();
          StraightPathEvent anotherEvent = new StraightPathEvent();
          this.game.getEvents().addLast(anotherEvent);
          
          GameStatus status = this.game.executeCommand(0);
          status = this.game.executeCommand(0);
          
          assertEquals(GameStatus.GAME_CONTINUE, status);
          assertEquals(true, this.game.getCurrentEvent() == anotherEvent);
     }
    
    @Test
    public void settingUpNextEventWorksWhenLastOne() {
        createTestEvents();
        
       GameStatus status = this.game.executeCommand(0);
       status = this.game.executeCommand(0);
       
       assertEquals(GameStatus.GAME_END, status);
    }
    
    private void createTestEvents() {
        ArrayDeque<GameEvent> events = this.game.getEvents();
        events.clear();
        events.add(new StraightPathEvent());
    }
    
}
