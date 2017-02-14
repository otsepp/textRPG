package textrpg.event.battle;

import textrpg.event.battle.BattleEvent;
import textrpg.event.battle.Attack;
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
        this.attack = new Attack(battleEvent);
    }
    
    
    @Test
    public void constructorWorks() {
        assertEquals(true, this.attack.getBattleEvent() != null);
        assertEquals(true, this.attack.getNewCommands() != null);
        assertEquals(true, this.attack.getPlayer() != null);
        assertEquals(true, this.attack.getEnemy() != null);
    }
    
    @Test
    public void executeCommandWorks() {
        this.attack.getEnemy().setHealth(this.attack.getPlayer().getTotalDamage() * 2);
        
        CommandReturnValues returnValues  = this.attack.executeCommand();
        assertEquals(true, returnValues.getNewCommands() != null);
        
        returnValues = this.attack.executeCommand();
        assertEquals(true, returnValues.getNewCommands() == null);
        
        assertEquals(false, this.attack.getBattleEvent().isPlayerTurn());
    }
    
}