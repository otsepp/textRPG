
package textrpg.events.battle_event;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.game_event.GameEventReturnValues;

public class BattleEventTest {
    
    public BattleEventTest() {
    }
    
    private BattleEvent event;
    
    @Before
    public void setUp() {
        this.event = new BattleEvent(new Player("Tester"), new Enemy("Tester's enemy"));
    }

    
    @Test
    public void playerAndEnemyAreNotNull() {
        assertEquals(true, this.event.getPlayer() != null);
        assertEquals(true, this.event.getEnemy() != null);
    }
    
    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.event.getCommands();
        assertEquals(1, commands.size());
        assertEquals(true, commands.get(0) != null);
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(1));
    }
    
    @Test
    public void initiateEventContinuesWhenNeitherDies() {
        GameEventReturnValues ret = this.event.initiateEvent(0);
        
        assertEquals(true, ret.getEventContinues());
        assertEquals(true, this.event.getCommands() != null);
    }
    
    @Test
    public void initiateEventEndsWhenEnemyDies() {
        this.event.getEnemy().setHealth(1);
        GameEventReturnValues ret = this.event.initiateEvent(0);
        assertEquals(null, this.event.getCommands());
        assertEquals(false, ret.getEventContinues());
    }
    
    @Test
    public void initiateEventEndsWhenPlayerDies() {
        this.event.getPlayer().setHealth(1);
        this.event.getEnemy().setHealth(1000);
        GameEventReturnValues ret = this.event.initiateEvent(0);
        assertEquals(null, this.event.getCommands());
        assertEquals(false, ret.getEventContinues());
    }
    
}
