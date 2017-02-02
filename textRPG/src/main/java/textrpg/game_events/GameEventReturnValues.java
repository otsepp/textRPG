
package textrpg.game_events;

import java.util.List;

public class GameEventReturnValues {
    private List<String> messages;
    private boolean eventContinues;
    
    public GameEventReturnValues(List<String> messages, boolean eventContinues) {
        this.messages = messages;
        this.eventContinues = eventContinues;
    }
    
    public List<String> getMessages() {
        return messages;
    }
    
    public boolean getEventContinues() {
        return eventContinues;
    }
    
    public void setEventContinues(boolean newValue) {
        this.eventContinues = newValue;
    }
    
}
