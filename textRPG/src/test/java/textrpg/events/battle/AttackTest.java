
package textrpg.events.battle;

import textrpg.events.battle.Attack;
import textrpg.events.battle.BattleEvent;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.CommandReturnValues;

public class AttackTest {
    
    private Attack attack;
    
    public AttackTest() {
    }
    
    @Before
    public void setUp() {
        BattleEvent battleEvent = new BattleEvent(new Player("Tester"), new Enemy("Tester's enemy"));
        this.attack = new Attack(battleEvent.getCommands(), battleEvent.getPlayer(), battleEvent.getEnemy(), battleEvent);
    }
    
    
    @Test
    public void constructorWorks() {
        assertEquals(true, this.attack.getNewCommands() != null);
        assertEquals(true, this.attack.getPlayer() != null);
        assertEquals(true, this.attack.getEnemy() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        this.attack.getEnemy().setHealth(this.attack.getPlayer().getTotalDamage() * 2);
        
        CommandReturnValues ret  = this.attack.executeCommand();
        assertEquals(true, ret.getNewCommands() != null);
        
        ret = this.attack.executeCommand();
        assertEquals(true, ret.getNewCommands() == null);
    }
    
}
