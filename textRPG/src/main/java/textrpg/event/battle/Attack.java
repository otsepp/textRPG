

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
     * Palauttaa komennon suorittamiseen liittyvät viestit ja uudet komennot. Uudet komennot ovat null-arvoiset,
     * jos vihollinen kuolee. Muuten ne pysyvät samana kuin ennen komennon suoritusta.
     * @return CommandReturnValues-olio sisältää komentoon liittyvät viestit ja uudet komennot
     */
    @Override
    public CommandReturnValues executeCommand() {
        super.messages.clear();

        int damage = this.player.getTotalDamage();
        this.enemy.takeDamage(damage);
        int remainingEnemyHealth = enemy.getHealth();
        
        super.messages.add(this.player.getName() + " attacks " + this.enemy.getName() + " for " + damage + " damage.");
        super.messages.add(this.enemy.getName() + " has " + remainingEnemyHealth + " health remaining.");
        
        if (remainingEnemyHealth > 0) {            
            this.battle.setPlayerTurn(false);
            return new CommandReturnValues(super.messages, super.newCommands);
            
        } else {
            this.battle.setEventImage(this.enemy.getDeathImage());
            
            this.battle.setPlayerTurn(true);
            messages.add(this.enemy.getName() + " is dead.");
            super.newCommands.clear();
            super.newCommands.add(new Continue());
            return new CommandReturnValues(super.messages, super.newCommands);
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
