package textrpg.event.battle;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

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
    public void commandWorks() {
        Enemy enemy = this.attack.getEnemy();
        int healthComparison = enemy.getHealth() - this.attack.getPlayer().getTotalDamage();
        this.attack.executeCommand();
      
        assertEquals(healthComparison, enemy.getHealth());
        assertEquals(false, this.attack.getBattleEvent().isPlayerTurn());
    }
    
}