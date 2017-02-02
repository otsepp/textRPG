
package textrpg.game_events;

import java.util.ArrayList;
import java.util.List;
import textrpg.characters.Bandit;
import textrpg.characters.Enemy;
import textrpg.characters.Player;
import textrpg.commands.Command;
import textrpg.commands.CommandReturnValues;

public class BattleEvent extends GameEvent{

    private Player player;
    private Enemy enemy;
    private boolean playerTurn;
    
    public BattleEvent(Player player) {
        super("", new ArrayList());
        fillCommandList();
        chooseAnEnemy();
        super.startMessage = "You find yourself facing a " + enemy.getName();
        this.playerTurn = true;
    }
    
    @Override
    protected final void fillCommandList() {
        this.commands.add(new Attack(this.player, this.enemy, super.commands));
    }
    
    private void chooseAnEnemy() {
        this.enemy = new Bandit();
    }
    
    
    
    public class Attack extends Command {
        private Player p;
        private Enemy e;
        private List<Command> commands;
        //nämä kenttinä siltä varalta jos luokka laitetaan omaan tiedostoon
        private boolean playerTurn;
        
        public Attack(Player p, Enemy e, List<Command> commands) { 
            super("Attack", 
                    "",
                    commands);
            this.p = p;
            this.e = e;
            this.playerTurn = true;
        }
        
        
        @Override
        public CommandReturnValues executeCommand() {
            
            
            return null;
        }
        
        
    }
    
}
