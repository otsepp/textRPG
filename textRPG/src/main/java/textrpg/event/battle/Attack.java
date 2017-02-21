

package textrpg.event.battle;

import java.util.ArrayList;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;
import textrpg.command.Continue;

/**
 * Komento, jolla pelaaja iskee vihollista.
 */
public class Attack extends Command {
    private Player player;
    private Enemy enemy;
    private BattleEvent battle;
    
    /**
     * Luo uuden olion.
     * @param battle Yhteenottotapahtuma, jossa komento suoritetaan
     */
    public Attack(BattleEvent battle) {
        super("Attack", //desc
                new ArrayList(),    //messages
                battle.getCommands());  //new commands
        this.player = battle.getPlayer();
        this.enemy = battle.getEnemy();
        this.battle = battle;
    }

    /**
     * Pelaaja iskee vihollista.
     * @return CommandReturnValues-olio sisältää komentoon liittyvät viestit ja uudet komennot
     */
    @Override
    public CommandReturnValues executeCommand() {
        super.messages.clear();
        this.battle.setPlayerTurn(false);

        int damage = this.player.getTotalDamage();
        this.enemy.takeDamage(damage);
        int remainingEnemyHealth = enemy.getHealth();
        
        super.messages.add(this.player.getName() + " attacks " + this.enemy.getName() + " for " + damage + " damage.");
        super.messages.add(this.enemy.getName() + " has " + remainingEnemyHealth + " health remaining.");
        
        return new CommandReturnValues(super.messages, super.newCommands);
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
