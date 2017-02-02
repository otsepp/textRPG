
package sudoku.textrpg.game_events.straight_path_event;

import java.util.ArrayList;
import sudoku.textrpg.commands.Command;
import sudoku.textrpg.commands.CommandReturnValues;
import sudoku.textrpg.game_events.GameEvent;
import sudoku.textrpg.game_events.GameEventReturnValues;

public class StraightPathEvent extends GameEvent{
    
    public StraightPathEvent() {
        super("You see a straight path in front of you.",      
                new ArrayList());
        fillCommandList();
    }
    
    
    
    @Override
    protected final void fillCommandList() {
        this.commands.add(new GoForward());
    }
    
    @Override
    public GameEventReturnValues executeCommand(int commandId) {
        
        if (commandId < 0 || commandId > this.commands.size() - 1) {
            return null;
        }
        
        Command command = this.commands.get(commandId);
        CommandReturnValues ret = command.executeCommand();
        
        this.commands = ret.getNewCommands();
        String endMessage = ret.getEndMessage();
        
        boolean eventContinues = true;
        if (this.commands == null) {
            eventContinues = false;
        }
        return new GameEventReturnValues(endMessage, eventContinues);
    }
    
}
