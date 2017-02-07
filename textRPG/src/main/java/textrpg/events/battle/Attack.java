
package textrpg.events.battle;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.command.Command;
import textrpg.command.CommandReturnValues;


public class Attack extends Command {
    private Player player;
    private Enemy enemy;
    
    //testi
    private BattleEvent battle;
    
    public Attack(List<Command> commands, Player player, Enemy enemy
    //testi
    , BattleEvent battle
    ) {
        super("Attack",
                new ArrayList(),
                commands);
        this.player = player;
        this.enemy = enemy;
        //testi
        this.battle = battle;
    }

    @Override
    public CommandReturnValues executeCommand() {
        super.messages.clear();

        int damage = this.player.getTotalDamage();
        this.enemy.takeDamage(damage);
        int remainingEnemyHealth = enemy.getHealth();
        
        super.messages.add(this.player.getName() + " attacks " + this.enemy.getName() + " for " + damage + " damage.");
        super.messages.add(this.enemy.getName() + " has " + remainingEnemyHealth + " health remaining.");
        
        this.battle.setPlayerTurn(false);
        
        if (remainingEnemyHealth > 0) {
            return new CommandReturnValues(super.messages, super.newCommands);
        } else {
            return new CommandReturnValues(super.messages, null);
        }
    }
    
    public Player getPlayer() {
        return this.player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

}
