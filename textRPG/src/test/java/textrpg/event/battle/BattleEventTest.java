
package textrpg.event.battle;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textrpg.characters.Bandit;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.Continue;

public class BattleEventTest {
    
    public BattleEventTest() {
    }
    
    private BattleEvent event;
    private final int commandsAmount = 2;
    
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
        
        assertEquals(this.commandsAmount, commands.size());
        for (Command c : commands) {
            assertEquals(true, c != null);
        }
    }
    
    @Test
    public void initiateEventDeniesWrongInput() {
        assertEquals(null, this.event.initiateEvent(-1));
        assertEquals(null, this.event.initiateEvent(commandsAmount));
    }
    
    @Test
    public void battleContinuesWhenNeitherDies() {
        this.event.initiateEvent(0);
        
        assertEquals(true, this.event.getCommands().size() > 1);
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
