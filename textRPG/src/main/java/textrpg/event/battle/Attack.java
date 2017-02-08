

package textrpg.event.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;

/**
 * Komento, jolla pelaaja iskee vihollista.
 */
public class Attack extends Command {
    private Player player;
    private Enemy enemy;
    private BattleEvent battle;
    
    public Attack(BattleEvent battle) {
        super("Attack", //desc
                new ArrayList(),    //messages
                battle.getCommands());  //new commands
        this.player = battle.getPlayer();
        this.enemy = battle.getEnemy();
        this.battle = battle;
    }

    /**
     * 
     * @return CommandReturnValues-olio sisältää komentoon liittyvät viestit ja uudet komennot. Uudet komennot ovat null-arvoiset,
     * jos vihollinen kuolee. Muuten ne pysyvät samana kuin ennen komennon suoritusta.
     */
    @Override
    public CommandReturnValues executeCommand() {
        this.battle.setPlayerTurn(false);
        super.messages.clear();

        int damage = this.player.getTotalDamage();
        this.enemy.takeDamage(damage);
        int remainingEnemyHealth = enemy.getHealth();
        
        super.messages.add(this.player.getName() + " attacks " + this.enemy.getName() + " for " + damage + " damage.");
        super.messages.add(this.enemy.getName() + " has " + remainingEnemyHealth + " health remaining.");
        
        if (remainingEnemyHealth > 0) {
            
            return new CommandReturnValues(super.messages, super.newCommands);
        } else {
            return new CommandReturnValues(super.messages, null);
        }
    }
    
    public BattleEvent getBattleEvent() {
        return this.battle;
    }
    
    public Player getPlayer() {
        return this.player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

}
