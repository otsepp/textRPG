
package textrpg.event.battle;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Bandit;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.Continue;
import textrpg.event.GameEventReturnValues;

public class BattleEventTest {
    
    public BattleEventTest() {
    }
    
    private BattleEvent event;
    
    @Before
    public void setUp() {
        this.event = new BattleEvent(new Player("Tester"), new Bandit());
    }
    
    @Test
    public void playerAndEnemyAreNotNull() {
        assertEquals(true, this.event.getPlayer() != null);
        assertEquals(true, this.event.getEnemy() != null);
    }
    
    @Test
    public void commandsAreCreated() {
        List<Command> commands = this.event.getCommands();
        
        for (Command c : commands) {
            assertEquals(true, c != null);
        }
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(this.event.getCommands().size()));
    }
    
    @Test
    public void battleContinuesWhenNeitherDies() {
        GameEventReturnValues returnValues = this.event.initiateEvent(0);
        assertEquals(true, returnValues.getEventContinues());
    }
    
    @Test
    public void battleEndsWhenEnemyDies() {
        this.event.getEnemy().setHealth(1);
        
        this.event.initiateEvent(0);
        
        Command newCommand = this.event.getCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
    }
    
    @Test
    public void battleEndsWhenPlayerDies() {
        this.event.getPlayer().setHealth(1);
        this.event.getEnemy().setHealth(1000);

        this.event.initiateEvent(0);
        
        Command newCommand = this.event.getCommands().get(0);
        assertEquals(true, newCommand instanceof Continue);
    }
    
}
