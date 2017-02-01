
package sudoku.textrpg.game_events;

import java.util.List;
import sudoku.textrpg.commands.Command;

public abstract class GameEvent {
    protected String startMessage;
    protected List<Command> commands;
    
    public GameEvent(String startMessage, List<Command> commands) {
        this.startMessage = startMessage;
        this.commands = commands;
    }
    
    protected abstract void fillCommandList();
    
    //tämä todennäköisesti katoaa
    public abstract void initiateEvent();
    
}
