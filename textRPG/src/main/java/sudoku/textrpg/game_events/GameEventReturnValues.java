
package sudoku.textrpg.game_events;

public class GameEventReturnValues {
    private String endMessage;
    private boolean eventContinues;
    
    public GameEventReturnValues(String endMessage, boolean eventContinues) {
        this.endMessage = endMessage;
        this.eventContinues = eventContinues;
    }
    
    public String getEndMessage() {
        return endMessage;
    }
    
    public boolean isEventContinues() {
        return eventContinues;
    }
    
}
